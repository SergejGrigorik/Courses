create table restaurant_operator
(
    id         SERIAL PRIMARY KEY,
    restaurant_id INT REFERENCES restaurant (id) NOT NULL NOT NULL ,
    user_id INT REFERENCES "user" (id) NOT NULL
);