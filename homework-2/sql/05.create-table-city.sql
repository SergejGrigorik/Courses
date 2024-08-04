-- город
create table city
(
    id        SERIAL PRIMARY KEY,
    region_id INT,
    name_city VARCHAR(128) NOT NULL
);