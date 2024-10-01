insert into role (role)
values ('COURIER'),
       ('ADMINISTRATOR'),
       ('USER');

insert into privilege(name_privilege)
values ('change order'),
       ('change dish'),
       ('write review'),
       ('change schedule_courier'),
       ('change schedule_restaurant');

insert into role_privilege(role_id, privilege_id)
values (1, 4),
       (2, 1),
       (2, 5),
       (2, 2),
       (3, 3),
       (3, 1);

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

insert into payment_card (cardholder, number_card, valid_thru, security_code)
values ('IVANOV_IVAN', '1111111111111111', '12.12.2030', 123),
       ('SVETA_SVETIKOVA', '22222222222222222', '11.11.2030', 345),
       ('PETR_PETROV', '3333333333333333', '10.10.2030', 122);

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

insert into restaurant (restaurant_chain_id, account_bank, location_coordinates, address_id, number)
values (1, 111111, '1234x1234', 4, 375255234534),
       (2, 333333, '2222x3333', 5, 375253256734),
       (3, 444444, '5555x2222', 6, 375333247391);

insert into application_user (profile_id, user_name, password, email, role)
values (1,'Grisha','1111', 'ivan@mail.com', 'USER'),
       (2,'Zevs', '2222', 'sveta@mail.com', 'USER'),
       (3,'Latosh', '3333', 'petr@mail.ru', 'USER'),
       (4,'KuharXantia', '4444', 'sergej@mail.com', 'ADMINISTRATOR'),
       (5,'KuharQ7', '5555', 'timofej@mail.com', 'ADMINISTRATOR'),
       (6,'Ganshard', '6666', 'andrej@mail.com', 'ADMINISTRATOR'),
       (7,'Gorod','4444','alex@mail.com','COURIER'),
       (8,'Misha','5555','maks@mail.com','COURIER'),
       (9,'Poluf','6666','artem@mail.com','COURIER');

insert into application_user_card (payment_card_id, application_user_id)
values (1, 1),
       (2, 2),
       (3, 3);

insert into restaurant_operator (restaurant_id, application_user_id)
values (1, 4),
       (2, 5),
       (3, 6);

insert into courier (application_user_id, location_coordinates_courier, courier_status)
values (7, '123x123', 'BUSY'),
       (8, '321x321', 'BUSY'),
       (9, '432x432', 'BUSY');

insert into schedule_courier (courier_id, working_hours_from, working_hours_to, day_of_week)
values (1, '09:00', '15:00', 'MONDAY'),
       (2, '15:00', '18:00', 'TUESDAY'),
       (3, '09:00', '15:00', 'WEDNESDAY');

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

insert into dish (name, category_id, restaurant_id, price, weight, pfcc_id, description)
values ('Margarita', 1, 1, 30, 1000, 1, 'tender pizza'),
       ('Rustica', 1, 1, 34, 1200, 2, 'large pizza'),
       ('Gamburger', 2, 2, 10, 300, 3, 'classic burger'),
       ('Сheeseburger', 2, 2, 13, 250, 4, 'a lot of cheese'),
       ('Penne', 3, 3, 34, 400, 5, 'one of the most popular types of pasta in Italy'),
       ('Fettuccine', 3, 3, 32, 400, 6,
        'thick noodles, 7 mm wide, similar to tagliatelle, the friability of which allows them to go well with all sorts of sauces and ingredients');




-- insert into role (id,role)
-- values (1,'courier'),
--        (2,'administrator'),
--        (3,'user');
--
-- insert into privilege(id,name_privilege)
-- values (1,'change order'),
--        (2,'change dish'),
--        (3,'write review'),
--        (4,'change schedule_courier'),
--        (5,'change schedule_restaurant');
--
-- insert into role_privilege(id,role_id, privilege_id)
-- values (1,1, 4),
--        (2,2, 1),
--        (3,2, 5),
--        (4,2, 2),
--        (5,3, 3),
--        (6,3, 1);
--
-- insert into region (id,name_region)
-- values (1,'Grodno'),
--        (2,'Minsk'),
--        (3,'Brest');
--
-- insert into city(id,region_id, name_city)
-- values (1,1, 'Grodno'),
--        (2,2, 'Minsk'),
--        (3,3, 'Brest');
--
-- insert into address (id,city_id, street, house, apartment)
-- values (1,1, 'Pushkova', '41', '23'),
--        (2,1, 'Kabjaka', '31', '32'),
--        (3,1, 'Olshanka', '25', '30'),
--        (4,1,'JankiKupala','87','34'),
--        (5,1, 'Pushkova', '12', '10'),
--        (6,1, 'Kabjaka', '24', '11'),
--        (7,1, 'Olshanka', '98', '17'),
--        (8,1,'JankiKupala','100','1');
--
-- insert into payment_card (id,cardholder, number_card, valid_thru, security_code)
-- values (1,'IVANOV_IVAN', '1111111111111111', '12.12.2030',123),
--        (2,'SVETA_SVETIKOVA', '22222222222222222', '11.11.2030',345),
--        (3,'PETR_PETROV','3333333333333333','10.10.2030',122);
--
-- insert into restaurant_chain(id,name)
-- values (1,'Pizzamania'),
--        (2,'Bigburger'),
--        (3,'PastaItaliano');
--
-- insert into profile (id,first_name, last_name, number, address_id)
-- values (1,'Ivan','Ivanov',375333210489,1),
--        (2,'Sveta','Svetikova',375255277787,2),
--        (3,'Petr','Petrov',37529988816824,3),
--        (4,'Sergej','Sergeev',375333764258,null),
--        (5,'Timofej','Timofeev',3752927378492,null),
--        (6,'Andrej','Andreev',3754446728939,null),
--        (7,'Leonid','Leonidov',375447382934,4),
--        (8,'Maksim','Maksimov',375299877657,5),
--        (9,'Artem','Artemov',375257283943,6);
--
-- insert into restaurant (id,restaurant_chain_id, account_bank, location_coordinates, address_id, number)
-- values (1,1,111111,'1234x1234',4,375255234534),
--        (2,2,333333,'2222x3333',5,375253256734),
--        (3,3,444444,'5555x2222',6,375333247391);
--
-- insert into "user" (id,profile_id, password, login, role_id)
-- values (1,1,'1111','ivan@mail.com',3),
--        (2,2,'2222','sveta@mail.com',3),
--        (3,3,'3333','petr@mail.ru',3),
--        (4,4,'4444','sergej@mail.com',2),
--        (5,5,'5555','timofej@mail.com',2),
--        (6,6,'6666','andrej@mail.com',2);
--
-- insert into user_card (id,payment_card_id, user_id)
-- values (1,1,1),
--        (2,2,2),
--        (3,3,3);
--
-- insert into restaurant_operator (id,restaurant_id, user_id)
-- values (1,1,4),
--        (2,2,5),
--        (3,3,6);
--
-- insert into courier (id,profile_id, location_coordinates_courier, courier_status)
-- values (1,7,'123x123','BUSY'),
--        (2,8,'321x321','BUSY'),
--        (3,9,'432x432','BUSY');
--
-- insert into schedule_courier (id,courier_id, working_hours_from, working_hours_to, day)
-- values (1,1,'09:00','15:00','MONDAY'),
--        (2,2,'15:00','18:00','TUESDAY'),
--        (3,3,'09:00','15:00','WEDNESDAY');
--
-- insert into category (id,name)
-- values (1,'Pizza'),
--        (2,'Burger'),
--        (3,'Pasta');
--
-- insert into pfcc (proteins, fats, calories, carbohydrates)
-- values (12,12,34,100),
--        (14,12,45,454),
--        (34,23,12,333),
--        (33,22,11,233),
--        (2,12,11,544),
--        (32,11,32,325),
--        (12,32,12,455);
--
-- insert into dish (id,name, category_id, restaurant_id, price, weight, pfcc_id, description)
-- values (1,'Margarita',1,1,30,1000,1,'tender pizza'),
--        (2,'Rustica',1,1,34,1200,2,'large pizza'),
--        (3,'Gamburger',2,2,10,300,3,'classic burger'),
--        (4,'Сheeseburger',2,2,13,250,4,'a lot of cheese'),
--        (5,'Penne',3,3,34,400,5,'one of the most popular types of pasta in Italy'),
--        (6,'Fettuccine',3,3,32,400,6,'thick noodles, 7 mm wide, similar to tagliatelle, the friability of which allows them to go well with all sorts of sauces and ingredients');
--
-- insert into ingredient (id,name, weight, price)
-- VALUES (1,'Mushrooms',20,1),
--        (2,'Cheese',25,1),
--        (3,'Bacon',20,1);
