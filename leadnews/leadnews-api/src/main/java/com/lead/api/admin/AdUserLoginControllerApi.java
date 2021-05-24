package com.lead.api.admin;

import com.lead.model.admin.dto.AdUserDto;
import com.lead.model.common.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName LoginControllerApi
 * @date 2021/5/24 16:56
 * @Version 1.0
 * @Author ShyBoy
 */
@Api(value = "admin端用户登录",tags = "admin端用户登录",description = "admin端用户登录API")
public interface AdUserLoginControllerApi {
    /**
     * 登录功能
     * @param dto
     * @return
     */
    @ApiOperation("admin端用户登录")
    public ResponseResult login(@RequestBody AdUserDto dto);
}
