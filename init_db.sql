USE to_do_apps_docker;

CREATE TABLE romances (rid VARCHAR(100),
                       title VARCHAR(60),
                       price INT, PRIMARY KEY(rid), UNIQUE(title));

INSERT INTO romances
VALUES('510e8400-e29b-41d4-a716-446655440000','Give me a love',450),
      ('520e8400-e29b-41d4-a716-446655440000','Sweet dreams',400),
      ('530e8400-e29b-41d4-a716-446655440000','Go together',390);

