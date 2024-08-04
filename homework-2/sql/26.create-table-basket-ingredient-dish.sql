--доб ингредиентов в корзину
create table basket_ingredient_dish
(
    id                SERIAL PRIMARY KEY,
    basket_item_id    INT REFERENCES basket_item (id),
    ingredient        INT REFERENCES ingredient (id),
    count_ingredients INT     NOT NULL,
    price_amount      NUMERIC NOT NULL
);