package com.lead.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lead.model.admin.dto.AdUserDto;
import com.lead.model.admin.pojo.AdUser;
import com.lead.model.common.dtos.ResponseResult;

/**
 * @ClassName UserLoginService
 * @date 2021/5/24 16:58
 * @Version 1.0
 * @Author ShyBoy
 */
public interface AdUserLoginService extends IService<AdUser> {
    /**
     * 登录功能
     * @param dto
     * @return
     */
    ResponseResult login(AdUserDto dto);
}
