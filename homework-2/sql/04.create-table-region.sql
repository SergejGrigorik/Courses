-- область
create table region
(
    id          SERIAL PRIMARY KEY,
    name_region VARCHAR(128) NOT NULL UNIQUE
);