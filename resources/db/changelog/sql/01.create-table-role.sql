-- статус для входа в базу
create table role
(
    id   SERIAL PRIMARY KEY,
    role VARCHAR UNIQUE NOT NULL
);