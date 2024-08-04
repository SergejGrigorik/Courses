-- сам заказ
create table "order"
(
    id              SERIAL PRIMARY KEY,
    users_id        INT REFERENCES "user" (id)       NOT NULL,
    sum_price       NUMERIC                          NOT NULL,
    coupon_id       INT REFERENCES coupon (id),
    promo_code      INT REFERENCES coupon (id),
    status_order_id INT REFERENCES status_order (id) NOT NULL,
    status_payment  BIT                              NOT NULL
);