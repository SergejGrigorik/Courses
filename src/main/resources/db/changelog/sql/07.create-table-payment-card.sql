-- карточка для оплаты
create table payment_card
(
    id            SERIAL PRIMARY KEY,
    cardholder    VARCHAR(128) NOT NULL,
    number_card   BIGINT UNIQUE   NOT NULL UNIQUE,
    valid_thru    VARCHAR(128) NOT NULL,
    security_code INT          NOT NULL
);