package com.kciray.database;

import com.kciray.entity.address.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class RegionDataBase implements DataBase<Integer, Region>{
    private Map<Integer, Region> regionDataBase = new HashMap<>();
    @Autowired
    private GenerationId<Region> createId;
    @Override
    public Map<Integer, Region> getMapDataBase() {

        return regionDataBase;
    }

    @Override
    public Region getEntityFromDataBase(Region value) {
    return createId.addEntityDataBase(value, regionDataBase);
    }
}
