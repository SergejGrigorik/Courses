-- график работы курьера
create table schedule_courier
(
    id                 SERIAL PRIMARY KEY,
    courier_id         INT REFERENCES courier (id) NOT NULL,
    working_hours_from TIME,
    working_hours_to   TIME,
    day_of_week        VARCHAR(128)                NOT NULL,
    UNIQUE (courier_id, day_of_week)

);