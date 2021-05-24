package com.lead.admin.controller.v1;

import com.lead.admin.service.AdUserLoginService;
import com.lead.api.admin.AdUserLoginControllerApi;
import com.lead.model.admin.dto.AdUserDto;
import com.lead.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AdUserLoginController
 * @date 2021/5/24 17:08
 * @Version 1.0
 * @Author ShyBoy
 */
@RestController
@RequestMapping("/login")
@CrossOrigin
public class AdUserLoginController implements AdUserLoginControllerApi {

    @Autowired
    private AdUserLoginService adUserLoginService;

    @Override
    @PostMapping("/in")
    public ResponseResult login(AdUserDto dto) {
        return adUserLoginService.login(dto);
    }
}
