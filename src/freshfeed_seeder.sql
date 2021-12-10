USE thefreshfeed_db;

INSERT INTO user (first_name, last_name, email, username, password, is_vendor) VALUES
    ('Rodriques', 'Perry', 'mrperry@email.com', 'rperry', '$2a$12$LN32bi2notPL3i2N0XCTeeXFB1tEuFTu9Swl7RxVK8xyZnTl7K3Dy', true),
    ('John', 'Doe', 'john@doe.com', 'john', '$2a$12$LN32bi2notPL3i2N0XCTeeXFB1tEuFTu9Swl7RxVK8xyZnTl7K3Dy', false),
    ('Kevin', 'Orta', 'mrorta@email.com', 'korta', '$2a$12$LN32bi2notPL3i2N0XCTeeXFB1tEuFTu9Swl7RxVK8xyZnTl7K3Dy', true),
    ('Jane', 'Doe', 'jane@doe.com', 'jane', '$2a$12$LN32bi2notPL3i2N0XCTeeXFB1tEuFTu9Swl7RxVK8xyZnTl7K3Dy', false),
    ('Joanna', 'Foss', 'msfoss@email.com', 'jfoss', '$2a$12$LN32bi2notPL3i2N0XCTeeXFB1tEuFTu9Swl7RxVK8xyZnTl7K3Dy', true);

INSERT INTO vendor (user_id, vendor_name) VALUES
    (1, 'Perry\'s Veggie Platters'),
    (2, 'Orta\'s Milk Stand'),
    ((SELECT user.id FROM user WHERE user.first_name = 'Joanna'), 'Foss\'s Florals');

INSERT INTO ad (title, description) VALUES ('10 Bundles of Celery', '10 Bundle of Celery, Non-GMO, Freshly Sourced, Plentiful crops');
ALTER table ad ADD price int unsigned not null;
INSERT INTO ad (title, description, price) VALUES ('50 ears of Corn', 'Beautiful, yellow Corn, freshly pulled from stalks', '100')