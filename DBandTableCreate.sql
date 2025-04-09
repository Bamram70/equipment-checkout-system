CREATE DATABASE ECS;
USE ECS;
CREATE TABLE SystemUser (
    user_ID INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(45) NOT NULL,
    user_role ENUM('Employee', 'Administrator') NOT NULL DEFAULT 'Employee',
    user_pswrd VARCHAR(255) NOT NULL
);
CREATE TABLE Warehouse (
    warehouse_ID INT AUTO_INCREMENT PRIMARY KEY,
    w_location VARCHAR(255) NOT NULL
);

CREATE TABLE Administrator (
    admin_ID INT PRIMARY KEY,
    user_permissions TEXT NOT NULL,
    warehouse_ID INT,
    FOREIGN KEY (admin_ID) REFERENCES SystemUser(user_ID) ON DELETE CASCADE,
    FOREIGN KEY (warehouse_ID) REFERENCES Warehouse(warehouse_ID)
);

CREATE TABLE Equipment (
    equip_ID INT AUTO_INCREMENT PRIMARY KEY,
    equip_name VARCHAR(45) NOT NULL,
    type VARCHAR(45) NOT NULL,
    quantity INT NOT NULL
);

CREATE TABLE ToolConditionReport (
    report_ID INT AUTO_INCREMENT PRIMARY KEY,
    equip_ID INT NOT NULL,
    equip_cond VARCHAR(255),
    is_repair BOOLEAN NOT NULL,
    FOREIGN KEY (equipadministrator_ID) REFERENCES Equipment(equip_ID) ON DELETE CASCADE
);

CREATE TABLE InventoryDatabase (
    inven_ID INT AUTO_INCREMENT PRIMARY KEY,
    equip_ID INT NOT NULL,
    stock_thresh INT NOT NULL,
    low_stock_alert BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (equip_ID) REFERENCES Equipment(equip_ID) ON DELETE CASCADE
);

CREATE TABLE Notifications (
    alert_ID INT AUTO_INCREMENT PRIMARY KEY,
    alert_type VARCHAR(100) NOT NULL,
    recip_ID INT NOT NULL,
    status ENUM('Pending', 'Sent', 'Acknowledged') NOT NULL DEFAULT 'Pending',
    FOREIGN KEY (recip_ID) REFERENCES SystemUser(user_ID) ON DELETE CASCADE
);



CREATE TABLE Reports (
    report_ID INT AUTO_INCREMENT PRIMARY KEY,
    generated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    content VARCHAR(255) NOT NULL
);