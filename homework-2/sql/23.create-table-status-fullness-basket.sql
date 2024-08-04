-- если корзина пустая и юзер пробует сделать заказ - ошиька
create table status_fullness_basket
(
    id          SERIAL PRIMARY KEY,
    status_name VARCHAR(128) NOT NULL UNIQUE
);