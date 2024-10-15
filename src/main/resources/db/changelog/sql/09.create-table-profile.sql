
create table profile
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(128)                NOT NULL,
    last_name  VARCHAR(128)                NOT NULL,
    number     BIGINT                       NOT NULL UNIQUE,
    address_id INT REFERENCES address (id)
);