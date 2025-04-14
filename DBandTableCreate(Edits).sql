SELECT * FROM systemuser;
SELECT * FROM equipment;
SELECT * FROM administrator;
SELECT * FROM toolconditionreport;
SELECT * FROM warehouse;

ALTER TABLE systemuser MODIFY user_role ENUM('admin', 'employee') NOT NULL DEFAULT 'employee';
UPDATE SystemUser SET user_role = 'employee' WHERE user_role NOT IN ('employee');

SHOW CREATE TABLE systemuser;
INSERT INTO systemuser (user_name, user_pswrd, user_role) VALUES ('testuser', 'testpass', 'admin');

DELETE FROM systemuser;
ALTER TABLE systemuser AUTO_INCREMENT = 1;

SET SQL_SAFE_UPDATES = 0;

INSERT INTO systemuser (user_name, user_pswrd, user_role) VALUES ('Brendan', 'password', 'admin');
INSERT INTO systemuser (user_name, user_pswrd, user_role) VALUES ('Jayden', 'password', 'Employee');

ALTER TABLE equipment
ADD COLUMN `condition` VARCHAR(50),
ADD COLUMN `is_checked_out` TINYINT(1) DEFAULT 0,
ADD COLUMN `warehouse_id` INT;

ALTER TABLE equipment ADD COLUMN return_date DATE DEFAULT NULL;