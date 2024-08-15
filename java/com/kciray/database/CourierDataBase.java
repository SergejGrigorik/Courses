package com.kciray.database;

import com.kciray.entity.Courier;

import com.kciray.entity.PaymentCard;
import com.kciray.entity.User;
import com.kciray.entity.status.CourierStatus;
import lombok.Value;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.kciray.entity.status.RoleEnum.COURIER;


@Component
public class CourierDataBase implements DataBase<Integer,Courier> {
    private static CourierDataBase courierDataBase;
    private  Map<Integer, Courier> courierDataBaseMap = new HashMap<>();

    private CourierDataBase() {
        add();
    }
    public static CourierDataBase getInstance(){
        if(courierDataBase==null){
            courierDataBase=new CourierDataBase();
        }
        return courierDataBase;
    }

    private  void add() {
        UserDataBase userDataBase = UserDataBase.getInstance();
        List<User> collect = userDataBase.getUserDataBaseMap().values().stream().filter(s -> s.getRole().getRole().equals(COURIER)).collect(Collectors.toList());
        int size = collect.size();
        int i = 0;
        int id = 1;
        int idUser = 0;

        while (size > 0) {

            if (i == 0) {
                courierDataBaseMap.put(id, Courier.builder()
                        .id(id)
                        .courierStatus(CourierStatus.FREE)
                        .locationCoordinates("123x123")
                        .user(collect.get(idUser))
                        .build());
                i = 1;
                size--;
                id++;
                idUser++;
            } else if (i == 1) {
                courierDataBaseMap.put(id, Courier.builder()
                        .id(id)
                        .locationCoordinates("123x123")
                        .courierStatus(CourierStatus.BUSY)
                        .user(collect.get(idUser))
                        .build());
                i = 2;
                size--;
                id++;
                idUser++;
            } else {
                courierDataBaseMap.put(id, Courier.builder()
                        .id(id)
                        .locationCoordinates("123x123")
                        .courierStatus(CourierStatus.WEEKEND)
                        .user(collect.get(idUser))
                        .build());
                i = 0;
                size--;
                id++;
                idUser++;
            }
        }
    }

    @Override
    public Map<Integer, Courier> getMapDataBase() {
        return courierDataBaseMap;
    }

    @Override
    public Courier addEntityDataBase(Courier courier) {
        if(courier.getId() == 0) {
            Integer id = searсhLastElement();
            courier.setId(id);
            courierDataBaseMap.put(id, courier);
            return courierDataBaseMap.get(id);
        }else {
            courierDataBaseMap.put(courier.getId(), courier);
        }
        return courierDataBaseMap.get(courier.getId());
    }
    private Integer searсhLastElement() {
        List<Integer> listKey = new ArrayList<>(courierDataBaseMap.keySet());
        List<Integer> listSortKey = listKey.stream().sorted().collect(Collectors.toList());
        Integer lastElement = listSortKey.get(listSortKey.size() - 1);
        return ++lastElement;
    }
}


//
//
//private void addCourierList() {
//    UserDataBase userDataBase = UserDataBase.getInstance();
//    couriers.put( 1 ,Courier.builder()
//            .id(1)
//            .courierStatus(CourierStatus.FREE)
//            .locationCoordinates("123x123")
//            .user(User.builder()
//                    .id(1)
//                    .profile(Profile.builder()
//                            .id(1)
//                            .firstName("Gena")
//                            .lastName("Gorodok")
//                            .number(007)
//                            .build())
//                    .role(Role.builder()
//                            .role(RoleEnum.COURIER)
//                            .build())
//                    .login("GenaSchukaRibachok@mail.mus")
//                    .password(1111)
//                    .build())
//            .build());
//    couriers.put(2,Courier.builder()
//            .id(2)
//            .locationCoordinates("123x123")
//            .courierStatus(CourierStatus.BUSY)
//            .user(User.builder()
//                    .id(2)
//                    .role(Role.builder()
//                            .role(RoleEnum.COURIER)
//                            .build())
//                    .login("MishanjaNormSrtoitel@mail.voen")
//
//                    .password(2222)
//                    .build())
//            .build());
//    couriers.put(3,Courier.builder()
//            .id(3)
//            .locationCoordinates("123x123")
//            .courierStatus(CourierStatus.WEEKEND)
//            .user(User.builder()
//                    .id(3)
//                    .role(Role.builder()
//                            .role(RoleEnum.COURIER)
//                            .build())
//                    .login("OdnorukijAlfaRameoAndMinskRulit@mail.azot")
//                    .password(3333)
//                    .build())
//            .build());
//}