-- корзина в которой продукты
create table basket_item
(
    id        SERIAL PRIMARY KEY,
    basket_id INT REFERENCES basket (id) NOT NULL,
    dish_id   INT REFERENCES dish (id)   NOT NULL,
    price     NUMERIC                    NOT NULL
);