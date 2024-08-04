-- у юзера может быть нескольок карточек
create table user_card
(
    id           SERIAL PRIMARY KEY,
    payment_card_id INT REFERENCES payment_card (id) ON DELETE CASCADE,
    user_id      INT REFERENCES "user" (id) ON DELETE CASCADE
);