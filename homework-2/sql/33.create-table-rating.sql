-- рейтинг
create table rating
(
    id            SERIAL PRIMARY KEY,
    order_id      INT REFERENCES "order" (id) NOT NULL,
    rating        VARCHAR(128),
    review        TEXT,
    user_id       INT REFERENCES "user" (id),
    restaurant_id INT REFERENCES restaurant (id)
);