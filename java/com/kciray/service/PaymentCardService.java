package com.kciray.service;

import com.kciray.dao.PaymentCardDao;
import com.kciray.dto.PaymentCardDto;
import com.kciray.entity.PaymentCard;
import com.kciray.mapper.CreateEntityMapper;
import com.kciray.mapper.ReadEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentCardService implements Services<Integer,PaymentCardDto> {
    @Autowired
    private PaymentCardDao paymentCardDao;
    @Autowired
    private ReadEntityMapper<PaymentCard, PaymentCardDto> readMapper;

    @Autowired
    private CreateEntityMapper<PaymentCardDto, PaymentCard> createdMapper;

    public PaymentCardDto create(PaymentCardDto paymentCard) {
        PaymentCard paymentCardToSave = createdMapper.toEntity(paymentCard, PaymentCard.class);
        PaymentCard paymentCardFromSave = paymentCardDao.save(paymentCardToSave);
        return readMapper.toDto(paymentCardFromSave,PaymentCardDto.class);
    }


    public Optional<PaymentCardDto> findById(Integer id) {
        Optional<PaymentCard> paymentCard = paymentCardDao.findById(id);
        return Optional.ofNullable(readMapper.toDto(paymentCard.orElseThrow(()->new RuntimeException(String.format("++Entity by id = %d does not exist", id))), PaymentCardDto.class));
    }

    public List<PaymentCardDto> findAll() {
        List<PaymentCard> paymentCards = paymentCardDao.findAll();
        return paymentCards.stream().map(entity -> readMapper.toDto(entity, PaymentCardDto.class)).collect(Collectors.toList());
    }

    public boolean deleteById(Integer id) {
        return paymentCardDao.findById(id)
                .map(entity -> {
                    paymentCardDao.delete(id);
                    return true;
                })
                .orElse(false);
    }

    public Optional<PaymentCardDto> update(Integer id, PaymentCardDto paymentCardDto) {
        paymentCardDao.update(id,createdMapper.toEntity(paymentCardDto, PaymentCard.class));
        return findById(id);

    }


}
