package com.kciray.database;

import com.kciray.entity.PaymentCard;
import com.kciray.entity.Role;
import com.kciray.entity.User;
import com.kciray.entity.status.RoleEnum;
import lombok.Data;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Data
public class UserDataBase implements DataBase<Integer, User> {
    private static UserDataBase userDataBase;
    private Map<Integer, User> userDataBaseMap = new HashMap<>();

    private UserDataBase() {
        add();
    }

    public static UserDataBase getInstance() {
        if (userDataBase == null) {
            userDataBase = new UserDataBase();
        }
        return userDataBase;
    }

    private void add() {
        for (int i = 0; i <= 30; i++) {
            if (i % 3 == 0) {
                userDataBaseMap.put(i, User.builder()
                        .id(i)
                        .password(i + 1111)
                        .login("senla@" + i + "com")
                        .role(Role.builder()
                                .role(RoleEnum.COURIER)
                                .build())

                        .build()
                );
            } else if (i % 4 == 0) {
                userDataBaseMap.put(i, User.builder()
                        .id(i)
                        .password(i + 1111)
                        .login("senla@" + i + "com")
                        .role(Role.builder()
                                .role(RoleEnum.ADMINISTRATOR)
                                .build())

                        .build());

            } else {
                userDataBaseMap.put(i, User.builder()
                        .id(i)
                        .password(i + 1111)
                        .login("senla@" + i + "com")
                        .role(Role.builder()
                                .role(RoleEnum.USER)
                                .build())

                        .build());
            }
        }
    }

    @Override
    public Map<Integer, User> getMapDataBase() {
        return userDataBaseMap;
    }

    @Override
    public User addEntityDataBase(User value) {
        Integer id = searсhLastElement();

        value.setId(id);
        userDataBaseMap.put(id, value);
        return userDataBaseMap.get(id);
    }
    private Integer searсhLastElement() {
        List<Integer> listKey = new ArrayList<>(userDataBaseMap.keySet());
        List<Integer> listSortKey = listKey.stream().sorted().collect(Collectors.toList());
        Integer lastElement = listSortKey.get(listSortKey.size() - 1);
        return ++lastElement;
    }
}
