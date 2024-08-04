-- рейтинг
create table rating
(
    id                  SERIAL PRIMARY KEY,
    order_id            INT REFERENCES "order" (id) NOT NULL,
    rating              VARCHAR(128),
    review              TEXT,
    users_id            INT REFERENCES "user" (id),
    restaurant_chain_id INT REFERENCES restaurant_chain (id),
    courier_id          INT REFERENCES courier (id)
);