create table role_privilege
(
    id           SERIAL PRIMARY KEY,
    role_id      INT REFERENCES role (id),
    privilege_id INT REFERENCES privilege (id)

);