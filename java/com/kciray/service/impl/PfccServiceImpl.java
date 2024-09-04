package com.kciray.service.impl;



import com.kciray.dao.impl.PfccDaoImpl;
import com.kciray.dto.PfccDto;
import com.kciray.entity.menu.Pfcc;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.PfccService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
//@Transaction

public class PfccServiceImpl extends AbstractService<Integer,Pfcc, PfccDto> implements BaseService<Integer,PfccDto>,
PfccService{


    @Autowired
    public PfccServiceImpl(PfccDaoImpl pfccDao) {
        super(Pfcc.class, PfccDto.class, pfccDao);
    }

    public PfccServiceImpl() {

    }

//    @Transaction
    @Override
    public PfccDto create(PfccDto entityDto) {
        Pfcc categoryCardToSave = modelMapper.map(entityDto, entityClass);
        Pfcc categoryCardFromSave = null;
            categoryCardFromSave = entityDao.save(categoryCardToSave);
        Optional<Pfcc> byId = entityDao.findById(categoryCardFromSave.getId());
        entityDao.delete(categoryCardFromSave.getId());
       return modelMapper.map(categoryCardFromSave, entityDtoClass);

    }

//    @Transaction
    @Override
    public Optional<PfccDto> update(Integer id, PfccDto categoryDto) {
        entityDao.update( modelMapper.map(categoryDto, entityClass));
        Optional<PfccDto> byId = findById(id);
        return byId;

    }

//        @Transaction
    @Override
    public Optional<PfccDto> findById(Integer id)  {
//        throw new RuntimeException();
        Optional<Pfcc> category = entityDao.findById(id);
        return Optional.ofNullable(modelMapper.map(category.orElseThrow(() -> new RuntimeException(String.format("Entity by id = %d does not exist", id))), entityDtoClass));
    }
}
