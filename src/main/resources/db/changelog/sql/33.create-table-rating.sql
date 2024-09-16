-- рейтинг
create table rating
(
    id            SERIAL PRIMARY KEY,
    booking_id      INT REFERENCES booking (id) NOT NULL,
    rating        VARCHAR(128),
    review        TEXT,
    application_user_id       INT REFERENCES application_user (id),
    restaurant_id INT REFERENCES restaurant (id)
);