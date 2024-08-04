create table address
(
    id        SERIAL PRIMARY KEY,
    city_id   INT REFERENCES city (id),
    street    VARCHAR(128) NOT NULL,
    house     VARCHAR(128) NOT NULL,
    apartment VARCHAR(128)
);