-- статус заказа (готовится , готово , в пути )
create table status_order
(
    id          SERIAL PRIMARY KEY,
    status_name INT NOT NULL UNIQUE
);