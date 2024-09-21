CREATE TABLE company (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    website VARCHAR(255) NOT NULL,
    created_at DATE NOT NULL
);