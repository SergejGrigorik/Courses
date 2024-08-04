create table administrator
(
    id            SERIAL PRIMARY KEY,
    first_name    VARCHAR(128)                   NOT NULL,
    last_name     VARCHAR(128)                   NOT NULL,
    restaurant_id INT REFERENCES restaurant (id) NOT NULL,
    password      INT                            NOT NULL,
    login         VARCHAR(128) UNIQUE            NOT NULL,
    role_id       INT REFERENCES role (id)       NOT NULL
)

