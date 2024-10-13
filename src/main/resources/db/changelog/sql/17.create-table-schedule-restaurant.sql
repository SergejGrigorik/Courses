--рабочий график компании
create table schedule_restaurant
(
    id                 SERIAL PRIMARY KEY,
    restaurant_id         INT REFERENCES restaurant (id) ON DELETE CASCADE ,
    working_hours_from TIME,
    working_hours_to   TIME,
    day_of_week                VARCHAR(128) NOT NULL,
    UNIQUE (restaurant_id, day_of_week )

);