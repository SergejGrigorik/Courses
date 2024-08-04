-- компании продукты которых я доставляю
create table restaurant
(
    id                   SERIAL PRIMARY KEY,
    restaurant_chain_id  INT REFERENCES restaurant_chain (id),
    account_bank         INT UNIQUE                  NOT NULL,
    location_coordinates VARCHAR(128)                NOT NULL,
    address_id           INT REFERENCES address (id) NOT NULL,
    number               INT                         NOT NULL,
    role_id              INT REFERENCES role (id)    NOT NULL
);