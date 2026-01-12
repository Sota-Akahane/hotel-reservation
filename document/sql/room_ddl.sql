DROP TABLE IF EXISTS rooms CASCADE;
CREATE TABLE rooms (
    id serial PRIMARY KEY,
    hotel_id INTEGER NOT NULL,
    name VARCHAR(50), -- シングル、ダブルなど
    capacity INTEGER NOT NULL,
    price INTEGER NOT NULL, -- 今は固定
    description TEXT,
    image_path VARCHAR(255),
    FOREIGN KEY (hotel_id) REFERENCES hotels (id)
);
