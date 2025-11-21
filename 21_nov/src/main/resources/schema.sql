CREATE TABLE IF NOT EXISTS airlines (
    airline_id SERIAL PRIMARY KEY,
    airline_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS flight (
    flight_id SERIAL PRIMARY KEY,
    airline_id INT NOT NULL,
    flight_number VARCHAR(255),
    from_location VARCHAR(255),
    to_location VARCHAR(255),
    depature_time TIMESTAMP,
    arrival_time TIMESTAMP,
    total_seats INT,
    avali_seats INT,
    price DOUBLE PRECISION
);

CREATE TABLE IF NOT EXISTS users (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS booking (
    booking_id SERIAL PRIMARY KEY,
    email_id VARCHAR(255),
    no_of_seats INT,
    status BOOLEAN,
    pnr VARCHAR(10),
    booking_time TIMESTAMP,
    flight_id INT,
    return_flight_id INT,
    user_id INT
);

CREATE TABLE IF NOT EXISTS passengers (
    passenger_id SERIAL PRIMARY KEY,
    booking_id INT,
    name VARCHAR(255),
    age INT,
    gender VARCHAR(20),
    meal VARCHAR(50),
    seat_no VARCHAR(10)
);
