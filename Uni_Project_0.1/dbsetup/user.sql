DROP DATABASE IF EXISTS projectstarter;
CREATE DATABASE projectstarter;
USE projectstarter;

CREATE TABLE USERS (
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
    
	INSERT INTO USERS (Username, Password) 
	    VALUES (username, password);
END;
/

CREATE PROCEDURE newAdmin (
	IN username VARCHAR(20),
    IN password VARCHAR(20)
)
BEGIN

	DECLARE dup_val_on_index_error CONDITION FOR 1062;
	DECLARE CONTINUE HANDLER FOR dup_val_on_index_error
	BEGIN
		SET @msg = CONCAT('Username ', username, ' is already recorded.');
		RESIGNAL SET MESSAGE_TEXT = @msg;
	END;
    
	INSERT INTO USERS (Username, Password, AccountType) 
	    VALUES (username, password, TRUE);
END;
/

CREATE PROCEDURE deleteUser (
	IN idToDelete INT
)
BEGIN
	DELETE FROM USERS WHERE Id = idToDelete;
END;
/

CREATE PROCEDURE loginCheck(
	IN username VARCHAR(20),
    IN password VARCHAR(20)
    )
BEGIN
	SELECT COUNT(Id) FROM USERS WHERE username = Username AND password = Password;
END;
/

CALL newAdmin ('Admin', 'Admin');
