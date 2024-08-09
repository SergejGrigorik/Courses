-- добавление блюда
create table order_item
(
    id       SERIAL PRIMARY KEY,
    order_id INT REFERENCES "order" (id) NOT NULL ,
    dish_id  INT REFERENCES dish (id)    NOT NULL,
    price    NUMERIC                     NOT NULL
);