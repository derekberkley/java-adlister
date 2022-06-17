
USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS ads (
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(30),
    description TEXT,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
    );
#
# DESCRIBE users;
# DESCRIBE ads;

# TODO: Verify that your application still functions as before, but that now
#  information is being pulled from and saved to your database
# TODO: We defined a one to many relationship between ads and users, so in order
#  to create an ad, we will need to tie it to an existing user record. For now,
#  manually insert a record into the users table and note the id of the newly created
#  record. In your controller, when an ad is being created, hardcode this id into the ad.

INSERT INTO users (username, email, password)
VALUES ('frank', 'frank@email.com', 'frank123');

# INSERT INTO ads (user_id, title, description)
# VALUES (1, 'Coding Services for Hire', 'Comes very cheap...');
#
# INSERT INTO ads (user_id, title, description)
# VALUES (1, 'Testing', 'Description Test');