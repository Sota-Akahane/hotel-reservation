DROP TABLE IF EXISTS hotels CASCADE;
CREATE TABLE hotels (
    id serial PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    image_path VARCHAR(255),
    zipcode VARCHAR(10),
    address VARCHAR(255),
    telephone VARCHAR(20),
    region_id INTEGER,
    deleted BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (region_id) REFERENCES regions (id)
);