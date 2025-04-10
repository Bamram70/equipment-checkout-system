-- Trigger to send a low stock notification after equipment quantity drops below threshold
DELIMITER //
CREATE TRIGGER AfterToolCheckout
AFTER UPDATE ON Equipment
FOR EACH ROW
BEGIN
    IF NEW.quantity < 5 THEN
        INSERT INTO Notifications (alert_type, recip_ID, status)
        VALUES ('Low Stock', 1, 'Pending');
    END IF;
END //
DELIMITER ;

-- Trigger to increment equipment quantity after a tool condition report is created
DELIMITER //
CREATE TRIGGER AfterToolReturn
AFTER INSERT ON ToolConditionReport
FOR EACH ROW
BEGIN
    UPDATE Equipment
    SET quantity = quantity + 1
    WHERE equip_ID = NEW.equip_ID;
END //
DELIMITER ;