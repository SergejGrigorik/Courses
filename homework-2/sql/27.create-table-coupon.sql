-- купон для скидки
create table coupon
(
    id         SERIAL PRIMARY KEY,
    restaurant_id INT REFERENCES restaurant (id) NOT NULL ,
    promo_code VARCHAR(128)                   NOT NULL,
    validity   VARCHAR(128)                   NOT NULL,
    discount   INT                            NOT NULL,
    UNIQUE (restaurant_id,promo_code)

);