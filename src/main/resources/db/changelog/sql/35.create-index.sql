create index role_privilege_role_id_idx on role_privilege (role_id);
create index role_privilege_privilege_id_idx on role_privilege (privilege_id);
create index city_region_id_idx on city (region_id);
create index address_city_id_idx on address (city_id);
create index restaurant_restaurant_chain_id_idx on restaurant (restaurant_chain_id);
create index restaurant_address_id_idx on restaurant (address_id);

create index profile_address_id_idx on profile (address_id);


create index user_card_user_idx on application_user_card (application_user_id);
create index courier_profile_id_idx on courier (application_user_id);
create index schedule_courier_courier_id_idx on schedule_courier (courier_id);

create index dish_category_id_idx on dish (category_id);
create index dish_restaurant_id_idx on dish (restaurant_id);
create index dish_pfcc_id_idx on dish (pfcc_id);
create index basket_restaurant_id_idx on basket (restaurant_id);
create index basket_user_id_idx on basket (application_user_id);

create index basket_item_basket_id_idx on basket_item (basket_id);
create index basket_item_dish_id_idx on basket_item (dish_id);


create index order_coupon_id_idx on booking (coupon_id);
create index order_promo_code_idx on booking(promo_code);

create index order_id_idx on delivery(booking_id);
create index delivery_courier_id_idx on delivery(courier_id);
create index delivery_address_id_user_idx on delivery(address_id_user);
create index delivery_restaurant_id_idx on delivery(restaurant_id);
create index order_item_order_id_idx on booking_item(booking_id);
create index order_item_dish_id_idx on booking_item(dish_id);

create index rating_order_id_idx on rating (booking_id);

create index restaurant_operator_restaurant_id_idx on restaurant_operator(restaurant_id);
create index restaurant_operator_user_id_idx on restaurant_operator(application_user_id);


