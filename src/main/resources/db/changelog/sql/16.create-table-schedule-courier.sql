-- график работы курьера
create table schedule_courier
(
    id                 SERIAL PRIMARY KEY,
    courier_id         INT REFERENCES courier (id) NOT NULL,
    working_hours_from VARCHAR(128)                NOT NULL,
    working_hours_to   VARCHAR(128)                NOT NULL,
    day_of_week        VARCHAR(128)                NOT NULL,
    UNIQUE (courier_id, day_of_week)

);