DROP TABLE IF EXISTS plans CASCADE;
CREATE TABLE plans (
    id serial PRIMARY KEY,
    hotel_id INTEGER NOT NULL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    FOREIGN KEY (hotel_id) REFERENCES hotels (id)
);
