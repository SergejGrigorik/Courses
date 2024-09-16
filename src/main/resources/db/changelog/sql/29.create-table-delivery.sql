-- инфо для доставки
create table delivery
(
    id                        SERIAL PRIMARY KEY,
    booking_id                  INT REFERENCES booking (id)    NOT NULL ,
    courier_id                INT REFERENCES courier (id)    NOT NULL ,
    delivery_time_from        TIMESTAMP                      NOT NULL,
    delivery_time_to          TIMESTAMP                      NOT NULL,
    location_coordinates_user VARCHAR(128)                   NOT NULL,
    address_id_user           INT REFERENCES address (id),
    restaurant_id             INT REFERENCES restaurant (id) NOT NULL
);