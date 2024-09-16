-- добавление блюда
create table booking_item
(
    id       SERIAL PRIMARY KEY,
    booking_id INT REFERENCES booking (id) NOT NULL ,
    dish_id  INT REFERENCES dish (id)    NOT NULL,
    price    NUMERIC                     NOT NULL
);