package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.*;
import com.kciray.model.Role;
import com.kciray.model.status.RoleEnum;
import com.kciray.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController extends Controllers<UserDto> implements ControllerInterfaceRun {

    @Autowired
    public UserController(BaseService<Integer, UserDto> services) {
        super(services);
    }

    @Override
    public void crudDemo() {

    }
}
