package com.kciray.service;

import com.kciray.dao.PfccDao;
import com.kciray.dto.PfccDto;
import com.kciray.entity.menu.Pfcc;
import com.kciray.mapper.CreateEntityMapper;
import com.kciray.mapper.ReadEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class PfccService implements Services<Integer,PfccDto> {
    @Autowired
    private PfccDao pfccDao;
    @Autowired
    private ReadEntityMapper<Pfcc, PfccDto> readMapper;

    @Autowired
    private CreateEntityMapper<PfccDto, Pfcc> createdMapper;

    public PfccDto create(PfccDto pfccDto) {
        Pfcc pfccCardToSave = createdMapper.toEntity(pfccDto, Pfcc.class);
        Pfcc pfccCardFromSave = pfccDao.save(pfccCardToSave);
        return readMapper.toDto(pfccCardFromSave, PfccDto.class);
    }


    public Optional<PfccDto> findById(Integer id) {
        Optional<Pfcc> pfcc = pfccDao.findById(id);
        return Optional.ofNullable(readMapper.toDto(pfcc.orElseThrow(()->new RuntimeException(String.format("++Entity by id = %d does not exist", id))), PfccDto.class));
    }

    public List<PfccDto> findAll() {
        List<Pfcc> pfccs = pfccDao.findAll();
        return pfccs.stream().map(entity -> readMapper.toDto(entity, PfccDto.class)).collect(Collectors.toList());
    }

    public boolean deleteById(Integer id) {
        return pfccDao.findById(id)
                .map(entity -> {
                    pfccDao.delete(id);
                    return true;
                })
                .orElse(false);
    }

    public Optional<PfccDto> update(Integer id, PfccDto pfccDto) {
        pfccDao.update(id,createdMapper.toEntity(pfccDto, Pfcc.class));
        return findById(id);

    }
}
