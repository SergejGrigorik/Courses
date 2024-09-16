-- сущность курьер
create table courier
(
    id                           SERIAL PRIMARY KEY,
    application_user_id          INT REFERENCES application_user (id) NOT NULL,
    location_coordinates_courier VARCHAR(128)                         NOT NULL,
    courier_status               VARCHAR(128)                         NOT NULL
);