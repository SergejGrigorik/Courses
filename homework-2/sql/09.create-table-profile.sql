-- профайл для курьера и
create table profile
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(128)                NOT NULL,
    last_name  VARCHAR(128)                NOT NULL,
    number     INT                         NOT NULL UNIQUE,
    address_id INT REFERENCES address (id) NOT NULL,
    role_id    INT REFERENCES role (id)    NOT NULL,
    password   INT                         NOT NULL,
    login      VARCHAR(128) UNIQUE         NOT NULL
);