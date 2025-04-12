
-- Create a log table to track tool checkouts and overdue status
CREATE TABLE ToolLog (
    log_ID INT AUTO_INCREMENT PRIMARY KEY,
    tool_ID INT NOT NULL,
    employee_ID INT NOT NULL,
    checkout_date DATETIME NOT NULL,
    due_date DATETIME NOT NULL,
    return_date DATETIME DEFAULT NULL,
    is_overdue BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (tool_ID) REFERENCES Tools(tool_ID) ON DELETE CASCADE,
    FOREIGN KEY (employee_ID) REFERENCES SystemUser(user_ID) ON DELETE CASCADE
);

-- Create a table for storing generated reports
CREATE TABLE ReportArchive (
    report_ID INT AUTO_INCREMENT PRIMARY KEY,
    report_name VARCHAR(100) NOT NULL,
    generated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    file_path VARCHAR(255) NOT NULL
);
-- Query to retrieve the latest report upon login
SELECT 
    report_name, file_path, generated_date
FROM
    ReportArchive
ORDER BY generated_date DESC
LIMIT 1;

