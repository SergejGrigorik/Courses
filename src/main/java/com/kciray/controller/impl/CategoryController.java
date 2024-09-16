package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.CategoryDto;
import com.kciray.service.BaseService;
import com.kciray.service.impl.CategoryServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component

public class CategoryController extends Controllers<CategoryDto>  {

     @Autowired
    public CategoryController(BaseService<Integer,CategoryDto> services) {
        super(services);
    }


}
