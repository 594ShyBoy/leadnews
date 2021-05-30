package com.lead.api.wemedia;

import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.media.dto.WmUserDto;
import io.swagger.annotations.Api;

/**
 * @ClassName LoginControllerApi
 * @date 2021/5/29 16:21
 * @Version 1.0
 * @Author ShyBoy
 */
@Api(value = "自媒体用户登录",tags = "自媒体用户登录",description = "自媒体用户登录API")
public interface LoginControllerApi {
    /**
     * 自媒体登录
     * @param dto
     * @return
     */
    public ResponseResult login(WmUserDto dto);
}
