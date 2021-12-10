USE thefreshfeed_db;

INSERT INTO user (first_name, last_name, email, username, password, is_vendor) VALUES
    ('Rodriques', 'Perry', 'mrperry@email.com', 'rperry', 'password123', true),
    ('John', 'Doe', 'john@doe.com', 'john', 'password123', false),
    ('Kevin', 'Orta', 'mrorta@email.com', 'korta', 'password123', true),
    ('Jane', 'Doe', 'jane@doe.com', 'jane', 'password123', false),
    ('Joanna', 'Foss', 'msfoss@email.com', 'jfoss', 'password123', true);

INSERT INTO vendor (user_id, vendor_name) VALUES
    (1, 'Perry\'s Veggie Platters'),
    (2, 'Orta\'s Milk Stand'),
    ((SELECT user.id FROM user WHERE user.first_name = 'Joanna'), 'Foss\'s Florals');


INSERT INTO ad (title, description) VALUES ('10 Bundles of Celery', '10 Bundle of Celery, Non-GMO, Freshly Sourced, Plentiful crops');