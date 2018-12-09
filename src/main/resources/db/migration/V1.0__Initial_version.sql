CREATE TABLE account (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    second_name VARCHAR(100) NOT NULL,
    account_number VARCHAR(75) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO account VALUES(1, 'John', 'Doe', '1234');
INSERT INTO account VALUES(2, 'Jane', 'Doe', '1235');
INSERT INTO account VALUES(3, 'Jim', 'Taylor', '1236');