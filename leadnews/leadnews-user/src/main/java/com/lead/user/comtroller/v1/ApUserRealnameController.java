package com.lead.user.comtroller.v1;

import com.lead.api.user.ApUserRealnameControllerApi;
import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.user.dtos.AuthDto;
import com.lead.user.service.ApUserRealnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ApUserRealnameController
 * @date 2021/5/24 18:47
 * @Version 1.0
 * @Author ShyBoy
 */
@RestController
@RequestMapping("/api/v1/auth")
public class ApUserRealnameController implements ApUserRealnameControllerApi {

    @Autowired
    private ApUserRealnameService apUserRealnameService;

    @Override
    @PostMapping("/list")
    public ResponseResult loadListByStatus(AuthDto dto) {
        return apUserRealnameService.loadListByStatus(dto);
    }
}
