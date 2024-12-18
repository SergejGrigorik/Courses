create table application_user
(
    id         SERIAL PRIMARY KEY,
    profile_id INT REFERENCES profile (id) ON DELETE CASCADE,
    user_name  VARCHAR(128) UNIQUE      NOT NULL,
    password   VARCHAR(128) UNIQUE      NOT NULL,
    email      VARCHAR(128) UNIQUE      NOT NULL,
    role_id    INT REFERENCES role (id) NOT NULL
);