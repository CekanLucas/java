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


-- Get applications

CREATE TABLE applications (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    application_markdown TEXT NOT NULL
);

INSERT INTO applications (name, application_markdown) VALUES
('Harry Potter', '# Application for the Position of Defense Against the Dark Arts Professor\n\n- I assure you my experience with dark wizards is second to none.\n- My references include Dumbledore (deceased), Hogwarts School (please don’t check with current management).\n- Skills include: Parseltongue, Quidditch, and not dying.'),
('Hermione Granger', '# Application for the Position of Transfiguration Professor\n\n- I’ve been known to read textbooks for fun, even those not on the syllabus.\n- Time management skills: once used a Time-Turner to attend extra classes.\n- Creator of Dumbledore’s Army; excellent at organizing study groups.'),
('Lord Voldemort', '# Application for Supreme Overlord of Hogwarts\n\n- Former head boy with aspirations for greatness.\n- Passionate about pure-blood supremacy and dark arts.\n- Hobbies include: immortality, snake breeding, and world domination.\n- References unavailable (they’ve all been imperiused or are deceased).');
