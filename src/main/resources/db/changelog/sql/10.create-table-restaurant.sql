-- компании продукты которых я доставляю
create table restaurant
(
    id                   SERIAL PRIMARY KEY,
    restaurant_chain_id  INT REFERENCES restaurant_chain (id) ON DELETE CASCADE,
    account_bank         BIGINT UNIQUE                  NOT NULL,
    location_coordinates VARCHAR(128)                NOT NULL,
    address_id           INT REFERENCES address (id) NOT NULL,
    number               BIGINT                         NOT NULL,
    UNIQUE (address_id)

);