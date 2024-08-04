-- привилегии для "ролей"
create table privilege
(
    id             SERIAL PRIMARY KEY,
    name_privilege VARCHAR UNIQUE NOT NULL
);