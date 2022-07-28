
DROP TABLE IF EXISTS accounts;
CREATE TABLE accounts (
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255)
);

INSERT INTO accounts VALUES ('tom','secret');
INSERT INTO accounts VALUES ('jerry','secret');