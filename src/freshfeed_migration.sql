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

CREATE TABLE IF NOT EXISTS vendor (
    id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    user_id INT UNSIGNED,
    vendor_name VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE IF NOT EXISTS category (
    id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ad (
    id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    ven_id INT UNSIGNED,
    title VARCHAR(100) UNIQUE,
    description VARCHAR(500),
    ad_img_url VARCHAR(500) DEFAULT 'https://bit.ly/3lS54Hv',
    cat_id INT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (ven_id) REFERENCES vendor (id),
    FOREIGN KEY (cat_id) REFERENCES category (id)
);

CREATE TABLE IF NOT EXISTS favorite (
    id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    user_id INT UNSIGNED,
    ad_id INT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (ad_id) REFERENCES ad (id)
);