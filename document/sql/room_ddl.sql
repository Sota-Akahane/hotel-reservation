CREATE TABLE rooms (
    id serial PRIMARY KEY,
    hotel_id INT NOT NULL,
    room_type VARCHAR(50),
    capacity INT,
    price DECIMAL(10,2),
    description TEXT,
    FOREIGN KEY (hotel_id) REFERENCES hotels (id)
);
