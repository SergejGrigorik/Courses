-- история заказа на случай падения базы
create table story_order
(
    id                   SERIAL PRIMARY KEY,
    order_id             INT REFERENCES "order" (id) NOT NULL,
    location_coordinates VARCHAR(128)                NOT NULL,
    name_dish            VARCHAR(128)                NOT NULL,
    category_name        VARCHAR(128)                NOT NULL,
    restaurant_name      VARCHAR(128)                NOT NULL,
    amount               INT                         NOT NULL,
    price_amount         NUMERIC                     NOT NULL,
    promo_code           INT,
    discount             INT
);