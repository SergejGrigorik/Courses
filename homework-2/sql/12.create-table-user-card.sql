-- у юзера может быть нескольок карточек
create table user_card
(
    id           SERIAL PRIMARY KEY,
    payment_card INT REFERENCES payment_card (id),
    user_id      INT REFERENCES "user" (id)
);