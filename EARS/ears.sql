-- Drop the table if it exists
DROP TABLE IF EXISTS profile;

-- Create the profile table
CREATE TABLE profile (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    email TEXT,
    password TEXT,
    title TEXT
);

-- Insert sample records
INSERT INTO profile (name, email, password, title) VALUES ('asdf', 'asdf@asdf.com', 'asdf', 'asdf');
INSERT INTO profile (name, email, password, title) VALUES ('vishmi', 'vishmi@gmail.com', '1234', 'vishmi 1234');
