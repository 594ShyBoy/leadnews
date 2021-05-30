package com.lead.wemedia.controller.v1;

import com.lead.api.wemedia.LoginControllerApi;
import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.media.dto.WmUserDto;
import com.lead.wemedia.service.WmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @date 2021/5/29 16:41
 * @Version 1.0
 * @Author ShyBoy
 */
@RestController
@RequestMapping("/login")
public class LoginController implements LoginControllerApi {
    @Autowired
    private WmUserService wmUserService;

    @PostMapping("/in")
    @Override
    public ResponseResult login(@RequestBody WmUserDto dto) {

        return wmUserService.login(dto);
    }
}
