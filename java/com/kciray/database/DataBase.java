package com.kciray.database;

import com.kciray.entity.PaymentCard;
import com.kciray.entity.menu.Category;

import java.util.Map;

public interface DataBase<K,V> {
    Map<K,V> getMapDataBase ();
    V addEntityDataBase(V value);

}
