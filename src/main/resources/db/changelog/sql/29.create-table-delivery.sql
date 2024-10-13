-- инфо для доставки
create table delivery
(
    id              SERIAL PRIMARY KEY,
    booking_id      INT REFERENCES booking (id)    NOT NULL,
    courier_id      INT REFERENCES courier (id),
    delivery_date   DATE                           NOT NULL,
    delivery_time   TIME                           NOT NULL,
    address_id_user INT REFERENCES address (id),
    restaurant_id   INT REFERENCES restaurant (id) NOT NULL,
    look_courier    VARCHAR(128)
);