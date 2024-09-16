create table restaurant_operator
(
    id         SERIAL PRIMARY KEY,
    restaurant_id INT REFERENCES restaurant (id) NOT NULL ,
    application_user_id INT REFERENCES application_user (id) NOT NULL
);