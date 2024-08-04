-- сам заказ
create table "order"
(
    id              SERIAL PRIMARY KEY,
    user_id        INT REFERENCES "user" (id) NOT NULL,
    sum_price       NUMERIC                    NOT NULL,
    coupon_id       INT REFERENCES coupon (id),
    promo_code      INT REFERENCES coupon (id),
    status_order_id VARCHAR(128)               NOT NULL,
    status_payment  BIT                        NOT NULL,
    UNIQUE (coupon_id,promo_code)
);