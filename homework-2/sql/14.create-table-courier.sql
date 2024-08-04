-- сущность курьер
create table courier
(
    id                           SERIAL PRIMARY KEY,
    profile_id                   INT REFERENCES profile (id)        NOT NULL,
    location_coordinates_courier VARCHAR(128)                       NOT NULL,
    courier_status_id            INT REFERENCES courier_status (id) NOT NULL
);