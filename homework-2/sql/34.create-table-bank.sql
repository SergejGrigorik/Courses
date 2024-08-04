-- небольшая имитация банка
create table bank
(
    id                                SERIAL PRIMARY KEY,
    account_restaurant                INT          NOT NULL UNIQUE,
    cardholder_id                     VARCHAR(128) NOT NULL,
    number_card_id                    INT UNIQUE   NOT NULL UNIQUE,
    payment_amount                    INT          NOT NULL,
    balance_restaurant_before_payment INT          NOT NULL,
    balance_restaurant_after_payment  INT          NOT NULL
);