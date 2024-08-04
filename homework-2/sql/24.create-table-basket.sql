create table basket
(
    id                 SERIAL PRIMARY KEY,
    restaurant_id      INT REFERENCES restaurant (id) NOT NULL,
    user_id            INT REFERENCES "user" (id)     NOT NULL,
    status_fullness VARCHAR(128) NOT NULL
);