package com.kciray.service;

import com.kciray.dao.PaymentCardDao;
import com.kciray.dto.PaymentCardDto;
import com.kciray.entity.PaymentCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentCardService extends AbstractService<PaymentCard,PaymentCardDto> implements BaseService<Integer,PaymentCardDto> {

    @Autowired
    public PaymentCardService(PaymentCardDao paymentCardDao) {
        super(PaymentCard.class, PaymentCardDto.class, paymentCardDao);
    }

}


















//    @Autowired
//    private PaymentCardDao paymentCardDao;
//    @Autowired
//    private ReadEntityMapper<PaymentCard, PaymentCardDto> readMapper;
//
//    @Autowired
//    private CreateEntityMapper<PaymentCardDto, PaymentCard> createdMapper;
//
//    public PaymentCardDto create(PaymentCardDto paymentCard) {
//        PaymentCard paymentCardToSave = createdMapper.toEntity(paymentCard, PaymentCard.class);
//        PaymentCard paymentCardFromSave = paymentCardDao.save(paymentCardToSave);
//        return readMapper.toDto(paymentCardFromSave,PaymentCardDto.class);
//    }
//
//
//    public Optional<PaymentCardDto> findById(Integer id) {
//        Optional<PaymentCard> paymentCard = paymentCardDao.findById(id);
//        return Optional.ofNullable(readMapper.toDto(paymentCard.orElseThrow(()->new RuntimeException(String.format("++Entity by id = %d does not exist", id))), PaymentCardDto.class));
//    }
//
//    public List<PaymentCardDto> findAll() {
//        List<PaymentCard> paymentCards = paymentCardDao.findAll();
//        return paymentCards.stream().map(entity -> readMapper.toDto(entity, PaymentCardDto.class)).collect(Collectors.toList());
//    }
//
//    public boolean deleteById(Integer id) {
//        return paymentCardDao.findById(id)
//                .map(entity -> {
//                    paymentCardDao.delete(id);
//                    return true;
//                })
//                .orElse(false);
//    }
//
//    public Optional<PaymentCardDto> update(Integer id, PaymentCardDto paymentCardDto) {
//        paymentCardDao.update(id,createdMapper.toEntity(paymentCardDto, PaymentCard.class));
//        return findById(id);
//
//    }
//
//
//}
