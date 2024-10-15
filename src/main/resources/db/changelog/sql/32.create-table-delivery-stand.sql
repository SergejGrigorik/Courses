-- стенд для курьеров
create table delivery_stand
(
    id              SERIAL PRIMARY KEY,
    courier_id      INT REFERENCES courier (id),
    delivery_date   DATE                      NOT NULL,
    delivery_time   TIME                      NOT NULL,
    address_id_user INT REFERENCES address (id),
    delivery_id     INT REFERENCES delivery (id)   NOT NULL,
    restaurant_id   INT REFERENCES restaurant (id) NOT NULL,
    start_delivery  TIMESTAMP  DEFAULT now(),
    look_courier    VARCHAR(128)
);