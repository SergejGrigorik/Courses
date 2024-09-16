-- добавление ингред-ов
create table ingredient_dish
(
    id               serial primary key,
    booking_item_id    int references booking_item (id) ON DELETE CASCADE,
    ingredients_id   int references ingredient (id),
    count_ingredient INT     NOT NULL,
    price_amount     NUMERIC NOT NULL
);