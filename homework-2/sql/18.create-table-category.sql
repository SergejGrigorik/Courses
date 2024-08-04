-- категория еды (пицца , бургеры и т.д.)
create table category
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL UNIQUE
);