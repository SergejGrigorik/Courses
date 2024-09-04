 -- город
create table city
(
    id        SERIAL PRIMARY KEY,
    region_id INT REFERENCES region (id),
    name_city VARCHAR(128) NOT NULL
);