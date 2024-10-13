create table role_privilege
(
    role_id      INT REFERENCES role (id) ON DELETE CASCADE ,
    privilege_id INT REFERENCES privilege (id) ON DELETE CASCADE,
    primary key (role_id,privilege_id)
);