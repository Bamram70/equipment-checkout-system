-- Procedure to validate user credentials during login
DELIMITER //
CREATE PROCEDURE ValidateUser(IN username VARCHAR(255), IN userPassword VARCHAR(255))
BEGIN
    SELECT user_ID, user_role 
    FROM SystemUser
    WHERE user_name = username AND user_pswrd = userPassword; 
END //
DELIMITER ;

-- Procedure to handle tool checkout and update stock quantity
DELIMITER //
CREATE PROCEDURE CheckoutTool(IN inputEquipmentID INT, OUT successMessage VARCHAR(255))
BEGIN
    DECLARE currentQuantity INT;

    SELECT quantity INTO currentQuantity FROM Equipment WHERE equip_ID = inputEquipmentID; 

    IF currentQuantity > 0 THEN
        UPDATE Equipment SET quantity = quantity - 1 WHERE equip_ID = inputEquipmentID;
        INSERT INTO InventoryDatabase (equip_ID, stock_threshold, low_stock_alert)
        VALUES (inputEquipmentID, 10, FALSE);
        SET successMessage = 'Tool successfully checked out.';
    ELSE
        SET successMessage = 'Insufficient stock.';
    END IF;
END//
DELIMITER ;

-- Procedure to process tool return and log condition reports
DELIMITER //
CREATE PROCEDURE ReturnTool(IN inputEquipmentID INT, IN inputCondition ENUM('New', 'Normal Wear', 'Needs Repair'), IN inputIsRepairable BOOLEAN)
BEGIN
    INSERT INTO ToolConditionReport (equip_ID, tool_cond)
    VALUES (inputEquipmentID, inputCondition);
END//
DELIMITER ;

-- Procedure to generate low stock alerts for equipment
DELIMITER //
CREATE PROCEDURE GenerateLowStockAlert(IN inputEquipmentID INT)
BEGIN
    DECLARE stockQuantity INT;

    SELECT quantity INTO stockQuantity FROM Equipment WHERE equip_ID = inputEquipmentID; 

    IF stockQuantity < 5 THEN
        INSERT INTO Notifications (alert_type, recip_ID, status)
        VALUES ('Low Stock', 1, 'Pending'); 
    END IF;
END//
DELIMITER ;