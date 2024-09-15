--рабочий график компании
create table schedule_restaurant
(
    id                 SERIAL PRIMARY KEY,
    restaurant_id         INT REFERENCES restaurant (id) ON DELETE CASCADE ,
    working_hours_from VARCHAR(128) NOT NULL,
    working_hours_to   VARCHAR(128) NOT NULL,
    "day"               VARCHAR(128) NOT NULL,
    UNIQUE (restaurant_id, "day")

);