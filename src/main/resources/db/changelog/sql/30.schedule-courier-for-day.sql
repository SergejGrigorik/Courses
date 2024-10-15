create table schedule_courier_for_day
(
    id       SERIAL PRIMARY KEY,
    courier_id INT REFERENCES courier ,
    schedule_courier_id INT REFERENCES  schedule_courier,
    working_hours_from TIME  ,
    working_hours_to TIME ,
    day VARCHAR(128) ,
    busy VARCHAR(128)

);