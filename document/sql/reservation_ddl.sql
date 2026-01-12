DROP TABLE IF EXISTS reservations CASCADE;
CREATE TABLE reservations (
    id serial PRIMARY KEY,
    user_id INTEGER NOT NULL,
    room_id INTEGER NOT NULL,

    checkin_date DATE NOT NULL,
    checkout_date DATE NOT NULL,
    guest_count INTEGER NOT NULL,

    plan_id INTEGER, -- 今は意味を持たせない
    payment_method INTEGER NOT NULL,

    total_price INTEGER NOT NULL,
    status INTEGER,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (room_id) REFERENCES rooms (id)
);
