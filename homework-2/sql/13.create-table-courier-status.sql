-- статус занятости курьера
create table courier_status
(
    id          SERIAL PRIMARY KEY,
    name_status VARCHAR(128) NOT NULL
);