package com.kciray.repository.impl;


import com.kciray.repository.RepositoryBase;
import com.kciray.repository.RestaurantOperatorDao;
import com.kciray.model.RestaurantOperator;

@org.springframework.stereotype.Repository
public class RestaurantOperatorRepositoryImpl extends RepositoryBase<Integer,RestaurantOperator> implements RestaurantOperatorDao {


    public RestaurantOperatorRepositoryImpl() {
        super(RestaurantOperator.class);
    }
//
//        public RestaurantOperator findRestaurantOperator(Integer id, String firstName, String lastName) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<RestaurantOperator> query = cb.createQuery(RestaurantOperator.class);
//        Root<RestaurantOperator> restaurantRoot = query.from(RestaurantOperator.class);
//
//         Join<RestaurantOperator, Restaurant> restaurantOperatorRestaurantJoin = restaurantRoot.join(RestaurantOperator_.restaurant);
//        Join<RestaurantOperator, User> restaurantOperatorUserJoin = restaurantRoot.join(RestaurantOperator_.user);
//        Join<User, Profile> profileJoin = restaurantOperatorUserJoin.join(User_.profile);
//
//        query.select(restaurantRoot).where(
//                cb.equal(restaurantRoot.get(RestaurantOperator_.restaurant).get(Restaurant_.id), id),
//                cb.equal(restaurantRoot.get(RestaurantOperator_.user).get(User_.profile).get(Profile_.lastName), lastName),
//                cb.equal(restaurantRoot.get(RestaurantOperator_.user).get(User_.profile).get(Profile_.firstName), firstName));
//        return entityManager.createQuery(query).getSingleResult();
//    }

}
