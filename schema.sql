CREATE TABLE phones (
    id SERIAL PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    year INTEGER NOT NULL,
    memory INTEGER NOT NULL,
    operating_system VARCHAR(100),
    has_five_g BOOLEAN,
    has_torch BOOLEAN,
    keyboard_type VARCHAR(100),
    has_cooling_system BOOLEAN,
    battery_capacity INTEGER,
    has_esim BOOLEAN,
    security_level VARCHAR(100),
    quantity INTEGER NOT NULL
);