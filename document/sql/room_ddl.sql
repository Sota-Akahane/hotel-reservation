CREATE TABLE rooms (
    id serial PRIMARY KEY,
    hotel_id INTEGER,
    room_type VARCHAR(50),
    capacity INTEGER NOT NULL,
    price INTEGER NOT NULL,
    description TEXT,
    FOREIGN KEY (hotel_id) REFERENCES hotels (id)
);
