-- ингредиедиенты которые можно добавлять
create table ingredient
(
    id     BIGSERIAL PRIMARY KEY,
    name   VARCHAR(128) NOT NULL UNIQUE ,
    weight NUMERIC      NOT NULL,
    price  NUMERIC      NOT NULL
);