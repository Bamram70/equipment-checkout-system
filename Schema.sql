-- ECS Database Creation
CREATE DATABASE ECS;
USE ECS;

-- Table to store system users and their login credentials
CREATE TABLE SystemUser (
    user_ID INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(45) NOT NULL,
    user_role ENUM('Employee', 'Administrator') NOT NULL DEFAULT 'Employee',
    user_pswrd VARCHAR(255) NOT NULL
);

-- Table to store warehouse details and locations
CREATE TABLE Warehouse (
    warehouse_ID INT AUTO_INCREMENT PRIMARY KEY,
    w_location VARCHAR(255) NOT NULL
);

-- Table to store administrator roles and their permissions, linked to warehouses
CREATE TABLE Administrator (
    admin_ID INT PRIMARY KEY,
    user_permissions TEXT NOT NULL,
    warehouse_ID INT,
    FOREIGN KEY (admin_ID) REFERENCES SystemUser(user_ID) ON DELETE CASCADE,
    FOREIGN KEY (warehouse_ID) REFERENCES Warehouse(warehouse_ID)
);

-- Table to store equipment details, types, and quantities
CREATE TABLE Equipment (
    equip_ID INT AUTO_INCREMENT PRIMARY KEY,
    equip_name VARCHAR(45) NOT NULL,
    equip_type VARCHAR(45) NOT NULL,
    quantity INT NOT NULL,
    warehouse_ID INT, 
    FOREIGN KEY (warehouse_ID) REFERENCES Warehouse(warehouse_ID)
);

-- Table to store materials data including types and quantities, linked to equipment
CREATE TABLE Materials (
    mate_ID INT AUTO_INCREMENT PRIMARY KEY, 
    mate_name VARCHAR(45) NOT NULL,
    mate_type VARCHAR(45) NOT NULL,
    quantity INT NOT NULL,
    equip_ID INT,
    FOREIGN KEY (equip_ID) REFERENCES Equipment(equip_ID)
);

-- Table to store tool details including types, quantities, and their association with equipment
CREATE TABLE Tools (
    tool_ID INT AUTO_INCREMENT PRIMARY KEY,
    tool_name VARCHAR(45) NOT NULL,
    tool_type VARCHAR(45) NOT NULL,
    quantity INT NOT NULL,
    equip_ID INT,
    FOREIGN KEY (equip_ID) REFERENCES Equipment(Equip_ID)
);

-- Table to track tool condition reports for maintenance and repair records
CREATE TABLE ToolConditionReport (
    report_ID INT AUTO_INCREMENT PRIMARY KEY,
    equip_ID INT NOT NULL,
    equip_cond ENUM('New', 'Normal Wear', 'Needs Repair') NOT NULL DEFAULT 'New',
    FOREIGN KEY (equip_ID) REFERENCES Equipment(equip_ID) ON DELETE CASCADE
);

-- Table to track inventory levels and manage stock thresholds for equipment, tools, and materials
CREATE TABLE InventoryDatabase (
    inven_ID INT AUTO_INCREMENT PRIMARY KEY,
    equip_ID INT NOT NULL,
    mate_ID INT NOT NULL,
    tool_ID INT NOT NULL,
    stock_thresh INT NOT NULL,
    low_stock_alert BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (equip_ID) REFERENCES Equipment(equip_ID) ON DELETE CASCADE,
    FOREIGN KEY (mate_ID) REFERENCES Materials(mate_ID) ON DELETE CASCADE,
    FOREIGN KEY (tool_ID) REFERENCES Tools(tool_ID) ON DELETE CASCADE
);

-- Table to store alert notifications for users, including stock alerts and overdue notices
CREATE TABLE Notifications (
    alert_ID INT AUTO_INCREMENT PRIMARY KEY,
    alert_type VARCHAR(100) NOT NULL,
    recip_ID INT NOT NULL,
    status ENUM('Pending', 'Sent', 'Acknowledged') NOT NULL DEFAULT 'Pending',
    FOREIGN KEY (recip_ID) REFERENCES SystemUser(user_ID) ON DELETE CASCADE
);

-- Table to store generated reports with timestamp and content
CREATE TABLE Reports (
    report_ID INT AUTO_INCREMENT PRIMARY KEY,
    generated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    content VARCHAR(255) NOT NULL
);