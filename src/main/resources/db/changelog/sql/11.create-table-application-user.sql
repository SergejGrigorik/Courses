create table application_user
(
    id         SERIAL PRIMARY KEY,
    profile_id INT REFERENCES profile (id) ON DELETE CASCADE,
    password   VARCHAR(128)                         NOT NULL,
    login      VARCHAR(128) UNIQUE         NOT NULL,
    role_id    INT REFERENCES role (id)    NOT NULL
);