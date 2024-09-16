-- статус для входа в базу
create table ROLE
(
    id   SERIAL PRIMARY KEY,
    role VARCHAR UNIQUE NOT NULL
);