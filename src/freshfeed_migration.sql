DROP DATABASE IF EXISTS thefreshfeed_db;

CREATE DATABASE IF NOT EXISTS thefreshfeed_db;

USE thefreshfeed_db;


CREATE TABLE IF NOT EXISTS user (
    id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    username VARCHAR(30) UNIQUE,
    password VARCHAR(100),
    is_vendor boolean,
    profile_img_url VARCHAR(100) DEFAULT 'https://bit.ly/3lSrOr0',
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS category (
    id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ad (
    id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(100) UNIQUE,
    description VARCHAR(500),
    ad_img_url VARCHAR(500) DEFAULT 'https://bit.ly/3lS54Hv',
    price DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id)

);



# CREATE TABLE IF NOT EXISTS favorite (
#     id INT UNSIGNED AUTO_INCREMENT NOT NULL,
#     user_id INT UNSIGNED,
#     ad_id INT UNSIGNED,
#     PRIMARY KEY (id),
#     FOREIGN KEY (user_id) REFERENCES user (id),
#     FOREIGN KEY (ad_id) REFERENCES ad (id)
# );