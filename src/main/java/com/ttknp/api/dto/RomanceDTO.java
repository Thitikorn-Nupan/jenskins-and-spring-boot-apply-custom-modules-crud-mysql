package com.ttknp.api.dto;

import com.ttknp.api.entity.Romance;
import com.ttknp.api.repository.ModelRepository;
import com.ttknp.jdbccustomservice.jdbc.select.JdbcSelectHelper;
import com.ttknp.jdbccustomservice.jdbc.update.JdbcInsertUpdateDeleteHelper;
import com.ttknp.jdbccustomservice.jdbc.utility.JdbcReadSQLFileHelper;
import com.ttknp.valiadationcustomservice.validation.UtilityStringHelper;
import com.ttknp.valiadationcustomservice.validation.ValidateHelperService;
import com.ttknp.webcustomservice.exception.ContentNotAllowed;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RomanceDTO implements ModelRepository<Romance> {

    private final JdbcSelectHelper<Romance> jdbcSelectHelper;
    private final JdbcInsertUpdateDeleteHelper<Romance> jdbcInsertUpdateDeleteHelper;
    private final JdbcReadSQLFileHelper jdbcReadSQLFileHelper;

    @Autowired
    public RomanceDTO(JdbcSelectHelper<Romance> jdbcSelectHelper, JdbcInsertUpdateDeleteHelper<Romance> jdbcInsertUpdateDeleteHelper, JdbcReadSQLFileHelper jdbcReadSQLFileHelper) {
        this.jdbcSelectHelper = jdbcSelectHelper;
        this.jdbcInsertUpdateDeleteHelper = jdbcInsertUpdateDeleteHelper;
        this.jdbcReadSQLFileHelper = jdbcReadSQLFileHelper;
    }


    //The @PostConstruct annotation in Java marks a method to be run after dependency injection is complete but before the bean goes into service,
    /*@PostConstruct
    private void initService() {
        jdbcReadSQLFileHelper.loadScriptRootPath("sql/init_db.sql");
    }*/

    @Override
    public List<Romance> retrieveAllModels() {
        return jdbcSelectHelper.selectAll(Romance.class);
    }


    @Override
    public <U> Romance retrieveModel(U key) {
        if (ValidateHelperService.isNotEmptyObject(key)) {
            return jdbcSelectHelper.selectOne(Romance.class,"rid",key);
        } else {
            RuntimeException runtimeException = new RuntimeException("Romance key is empty");
            throw new ContentNotAllowed(runtimeException);
        }
    }

    @Override
    public Boolean createModel(Romance model) {
        try {
            if (!ValidateHelperService.isNotEmptyString(model.getRid())) {
                model.setRid(UtilityStringHelper.getUUID());
                return jdbcInsertUpdateDeleteHelper.insertOne(Romance.class,model) > 0;
            } else {
                RuntimeException runtimeException = new RuntimeException("Romance key is not empty");
                throw new ContentNotAllowed(runtimeException);
            }
        } catch (IllegalAccessException e) {
            throw new ContentNotAllowed(e);
        }
    }

    @Override
    public Boolean updateModel(Romance model) {
        try {
            if (ValidateHelperService.isNotEmptyString(model.getRid())) {
                return jdbcInsertUpdateDeleteHelper.updateOne(Romance.class,"rid",model) > 0;
            } else {
                RuntimeException runtimeException = new RuntimeException("Romance key is empty");
                throw new ContentNotAllowed(runtimeException);
            }
        } catch (IllegalAccessException e) {
            throw new ContentNotAllowed(e);
        }
    }

    @Override
    public <U> Boolean deleteModel(U key) {
        if (ValidateHelperService.isNotEmptyObject(key)) {
            try {
                return jdbcInsertUpdateDeleteHelper.deleteOne(Romance.class,"rid",key) > 0;
            } catch (IllegalAccessException e) {
                throw new ContentNotAllowed(e);
            }
        } else {
            RuntimeException runtimeException = new RuntimeException("Romance key is empty");
            throw new ContentNotAllowed(runtimeException);
        }
    }

}
