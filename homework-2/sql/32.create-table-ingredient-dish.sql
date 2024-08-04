-- добавление ингред-ов
create table ingredient_dish
(
    id               serial primary key,
    order_item_id    int references order_item (id),
    ingredients_id   int references ingredient (id),
    count_ingredient INT     NOT NULL,
    price_amount     NUMERIC NOT NULL
);