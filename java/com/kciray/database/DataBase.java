package com.kciray.database;

import java.util.Map;

public interface DataBase<K,V> {
    Map<K,V> getMapDataBase ();
    V getEntityFromDataBase(V value);

}
