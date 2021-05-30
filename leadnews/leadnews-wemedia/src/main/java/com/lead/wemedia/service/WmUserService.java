package com.lead.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.media.dto.WmUserDto;
import com.lead.model.media.pojo.WmUser;

/**
 * @ClassName WmUserService
 * @date 2021/5/24 19:06
 * @Version 1.0
 * @Author ShyBoy
 */
public interface WmUserService extends IService<WmUser> {
    /**
     * 登录
     * @param dto
     * @return
     */
    public ResponseResult login(WmUserDto dto);
}
