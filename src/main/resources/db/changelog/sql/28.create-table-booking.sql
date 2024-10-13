-- сам заказ
create table booking
(
    id                  SERIAL PRIMARY KEY,
    application_user_id INT REFERENCES application_user (id) NOT NULL,
    sum_price           NUMERIC                              NOT NULL,
    coupon_id           INT REFERENCES coupon (id),
    promo_code          VARCHAR(128) ,
    status_order_id     VARCHAR(128)                         NOT NULL,
    status_payment      VARCHAR(128)                         NOT NULL,
    UNIQUE (coupon_id, promo_code)
);