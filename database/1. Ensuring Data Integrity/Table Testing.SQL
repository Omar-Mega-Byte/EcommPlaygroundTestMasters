-- Insert a user
INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com');

-- Retrieve and verify the inserted user
SELECT * FROM users WHERE email='john@example.com';

-- Update user info
UPDATE users SET name='John Updated' WHERE email='john@example.com';

-- Delete the user
DELETE FROM users WHERE email='john@example.com';

-- Confirm deletion
SELECT * FROM users WHERE email='john@example.com';