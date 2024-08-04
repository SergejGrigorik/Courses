--рабочий график компании
create table schedule_restaurant
(
    id                 SERIAL PRIMARY KEY,
    restaurant         INT REFERENCES restaurant (id),
    working_hours_from VARCHAR(128) NOT NULL,
    working_hours_to   VARCHAR(128) NOT NULL,
    day_id            INT REFERENCES day (id)
);