package com.kciray.mapper;

import com.kciray.dto.CourierDto;
import com.kciray.entity.Courier;
import com.kciray.mapper.interfaceMapper.CourierMapper;
import org.springframework.stereotype.Component;

@Component

public class CourierMapperImpl  {

    public CourierDto toDto(Courier fromObject) {
        return new CourierDto(
                fromObject.getLocationCoordinates(),
                fromObject.getCourierStatus()
        );
    }
}
