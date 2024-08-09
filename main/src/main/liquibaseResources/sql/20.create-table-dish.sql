-- собственно сама еда
create table dish
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(128)                   NOT NULL,
    category_id   INT REFERENCES category (id)   NOT NULL ,
    restaurant_id INT REFERENCES restaurant (id) NOT NULL ,
    price         NUMERIC                        NOT NULL,
    weight        NUMERIC                        NOT NULL,
    pfcc_id       INT REFERENCES pfcc (id),
    description   VARCHAR                        NOT NULL,
    discount      INT,
    UNIQUE (name, category_id,restaurant_id)
);