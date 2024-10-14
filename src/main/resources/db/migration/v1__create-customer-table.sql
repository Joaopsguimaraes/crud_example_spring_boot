CREATE TABLE CUSTOMER(
    id UUID PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE NOT NULL,
    age VARCHAR(100),
    address VARCHAR(255),
    city VARCHAR(150),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);