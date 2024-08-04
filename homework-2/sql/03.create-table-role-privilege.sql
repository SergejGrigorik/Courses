create table role_privilege
(
    id           SERIAL PRIMARY KEY,
    role_id      INT REFERENCES role (id) ON DELETE CASCADE ,
    privilege_id INT REFERENCES privilege (id) ON DELETE CASCADE
);