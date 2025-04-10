-- View to display all tools with stock quantity greater than zero
CREATE VIEW AvailableTools AS
SELECT equip_ID, equip_name, quantity
FROM Equipment
WHERE quantity > 0;

-- View to display tools marked as overdue with associated notifications
CREATE VIEW OverdueTools AS
SELECT Equipment.equip_name, Notifications.alert_type, Notifications.status
FROM Equipment
JOIN Notifications ON Equipment.equip_ID = Notifications.recip_ID
WHERE Notifications.alert_type = 'Overdue';