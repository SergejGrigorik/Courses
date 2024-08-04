create table "user"
(
    id         SERIAL PRIMARY KEY,
    profile_id INT REFERENCES profile (id),
    password   INT                         NOT NULL,
    login      VARCHAR(128) UNIQUE         NOT NULL
);