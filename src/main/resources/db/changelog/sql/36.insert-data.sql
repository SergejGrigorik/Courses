insert into role (role)
values ('COURIER'),
       ('ADMINISTRATOR'),
       ('USER'),
       ('OPERATOR');


insert into privilege(name_privilege)
values ('DELETE_COUPON'),
       ('READ_COURIER'),
       ('UPDATE_COURIER'),
       ('DELETE_DISH'),
       ('DELETE_RESTAURANT_CHAIN'),
       ('READ_RESTAURANT'),
       ('READ_RESTAURANT_OPERATOR'),
       ('DELETE_USER)');

insert into role_privilege(role_id, privilege_id)
values (2, 1),
       (3, 1),
       (2, 2),
       (1, 2),
       (2, 3),
       (1, 3),
       (2, 4),
       (4, 4),
       (2, 5),
       (4, 5),
       (2, 6),
       (4, 6),
       (2, 7),
       (4, 7),
       (2, 8),
       (3, 8);

insert into region (name_region)
values ('Grodno'),
       ('Minsk'),
       ('Brest');

insert into city(region_id, name_city)
values (1, 'Grodno'),
       (2, 'Minsk'),
       (3, 'Brest');

insert into address (city_id, street, house, apartment)
values (1, 'Pushkova', '41', '23'),
       (1, 'Kabjaka', '31', '32'),
       (1, 'Olshanka', '25', '30'),
       (1, 'JankiKupala', '87', '34'),
       (1, 'Pushkova', '12', '10'),
       (1, 'Kabjaka', '24', '11'),
       (1, 'Olshanka', '98', '17'),
       (1, 'JankiKupala', '100', '1');

insert into restaurant_chain(name)
values ('Pizzamania'),
       ('Bigburger'),
       ('PastaItaliano');

insert into profile (first_name, last_name, number, address_id)
values ('Ivan', 'Ivanov', 375333210489, 1),
       ('Sveta', 'Svetikova', 375255277787, 2),
       ('Petr', 'Petrov', 37529988816824, 3),
       ('Sergej', 'Sergeev', 375333764258, null),
       ('Timofej', 'Timofeev', 3752927378492, null),
       ('Andrej', 'Andreev', 3754446728939, null),
       ('Leonid', 'Leonidov', 375447382934, 4),
       ('Maksim', 'Maksimov', 375299877657, 5),
       ('Artem', 'Artemov', 375257283943, 6);

insert into restaurant (restaurant_chain_id, account_bank, address_id, number)
values (1, 111111, 4, 375255234534),
       (2, 333333, 5, 375253256734),
       (3, 444444, 6, 375333247391);

insert into coupon(restaurant_id, promo_code, validity, discount)
values (1, '1111', 'VALID', 5),
       (1, '2222', 'VALID', 5),
       (1, '3333', 'VALID', 5);

insert into application_user (profile_id, user_name, password, email, role_id)
values (1, 'Grisha', '11111111', 'ivan@mail.com', 1),
       (2, 'Zevs', '2222222223333', 'sveta@mail.com', 1),
       (3, 'Latosh', '3333444444', 'petr@mail.ru', 1),
       (4, 'KuharXantia', '44444444', 'sergej@mail.com', 2),
       (5, 'KuharQ7', '55555555', 'timofej@mail.com', 2),
       (6, 'Ganshard', '666655555', 'andrej@mail.com', 2),
       (7, 'Gorod', '533333333', 'alex@mail.com', 3),
       (8, 'Misha', '555566666666', 'maks@mail.com', 3),
       (9, 'Poluf', '666611111111', 'artem@mail.com', 3);

insert into restaurant_operator (restaurant_id, application_user_id)
values (1, 4),
       (2, 5),
       (3, 6);

insert into courier (application_user_id, courier_status)
values (7, 'BUSY'),
       (8, 'BUSY'),
       (9, 'BUSY');

insert into schedule_courier (courier_id, working_hours_from, working_hours_to, day_of_week)
values (1, '09:00', '15:00:00', 'MONDAY'),
       (2, '15:00', '18:00:00', 'TUESDAY'),
       (3, '09:00', '15:00:00', 'WEDNESDAY');

insert into schedule_restaurant(restaurant_id, working_hours_from, working_hours_to, day_of_week)
values (1, '09:00', '15:00:00', 'MONDAY'),
       (2, '15:00', '18:00:00', 'TUESDAY'),
       (3, '09:00', '15:00:00', 'WEDNESDAY');

insert into category (name)
values ('Pizza'),
       ('Burger'),
       ('Pasta');

insert into pfcc (proteins, fats, calories, carbohydrates)
values (12, 12, 34, 100),
       (14, 12, 45, 454),
       (34, 23, 12, 333),
       (33, 22, 11, 233),
       (2, 12, 11, 544),
       (32, 11, 32, 325),
       (12, 32, 12, 455);

insert into dish (name, category_id, restaurant_id, price, weight, pfcc_id, description, availability)
values ('Margarita', 1, 1, 30, 1000, 1, 'tender pizza', 'AVAIBALE'),
       ('Rustica', 1, 1, 34, 1200, 2, 'large pizza', 'NOTAVAIBALE'),
       ('Gamburger', 2, 2, 10, 300, 3, 'classic burger', 'AVAIBALE'),
       ('Сheeseburger', 2, 2, 13, 250, 4, 'a lot of cheese', 'AVAIBALE'),
       ('Penne', 3, 3, 34, 400, 5, 'one of the most popular types of pasta in Italy', 'AVAIBALE'),
       ('Fettuccine', 3, 3, 32, 400, 6,
        'thick noodles, 7 mm wide, similar to tagliatelle, the friability of which allows them to go well with all sorts of sauces and ingredients',
        'AVAIBALE');




