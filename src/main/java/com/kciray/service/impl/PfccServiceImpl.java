package com.kciray.service.impl;
import com.kciray.dto.PaymentCardDto;
import com.kciray.dto.PfccDto;
import com.kciray.model.PaymentCard;
import com.kciray.model.menu.Pfcc;
import com.kciray.repository.PaymentCardRepository;
import com.kciray.repository.PfccRepository;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.PfccService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PfccServiceImpl extends AbstractService<Integer, Pfcc,PfccDto> implements BaseService<Integer, PfccDto>, PfccService {
    @Autowired
    public PfccServiceImpl(PfccRepository pfccRepository) {
        super(Pfcc.class, PfccDto.class, pfccRepository);
    }

}
