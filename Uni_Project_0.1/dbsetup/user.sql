DROP DATABASE IF EXISTS projectstarter;
CREATE DATABASE projectstarter;
USE projectstarter;

CREATE TABLE USERS (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	Username VARCHAR(20) UNIQUE NOT NULL,
    Password VARCHAR(20) NOT NULL,
    AccountType BOOLEAN DEFAULT FALSE
    # DOB DATE,
    # FName VARCHAR(20),
    # LName VARCHAR(20),
    # email VARCHAR(50)
);

/*
CREATE TABLE Address(
	UserID INT,
    FirstLine VARCHAR(20),
    SecondLine VARCHAR(20),
    City VARCHAR(20),
    County VARCHAR(20),
    Postcode VARCHAR(10)
);

CREATE TABLE CardDetails(
	UserID INT,
    CardName VARCHAR(20),
    CardNo INT,
    SortCode INT
);
*/

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
    IN password VARCHAR(20),
    
    OUT token INT
    )
BEGIN
	SELECT COUNT(Id) AS output FROM USERS WHERE username = Username AND password = Password;
    SET token = output;
END;
/

CALL newAdmin ('Admin', 'Admin');
