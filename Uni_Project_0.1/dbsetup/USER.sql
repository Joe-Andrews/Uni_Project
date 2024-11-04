DROP DATABASE IF EXISTS projectstarter;
CREATE DATABASE projectstarter;
USE projectstarter;

CREATE TABLE USER (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	Username VARCHAR(20) UNIQUE NOT NULL,
    Password VARCHAR(20) NOT NULL,
    AccountType BOOLEAN DEFAULT FALSE
);

DELIMITER /

CREATE PROCEDURE newUser (
	IN username  VARCHAR(20),
    IN password  VARCHAR(20)
)
BEGIN

	DECLARE dup_val_on_index_error CONDITION FOR 1062;
	DECLARE CONTINUE HANDLER FOR dup_val_on_index_error
	BEGIN
		SET @msg = CONCAT('Username ', username, ' is already recorded.');
		RESIGNAL SET MESSAGE_TEXT = @msg;
	END;
    
	INSERT INTO USER (Username, Password) 
	    VALUES (username, password);
END;

/
