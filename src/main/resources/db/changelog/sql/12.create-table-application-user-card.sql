-- у юзера может быть нескольок карточек
create table application_user_card
(
    id           SERIAL PRIMARY KEY,
    payment_card_id INT REFERENCES payment_card (id) ON DELETE CASCADE,
    application_user_id      INT REFERENCES application_user (id) ON DELETE CASCADE
);