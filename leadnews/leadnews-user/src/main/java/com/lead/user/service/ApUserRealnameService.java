package com.lead.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lead.model.common.dtos.PageResponseResult;
import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.user.dtos.AuthDto;
import com.lead.model.user.pojo.ApUserRealname;

/**
 * @ClassName ApUserRealnameService
 * @date 2021/5/23 8:19
 * @Version 1.0
 * @Author ShyBoy
 */
public interface ApUserRealnameService extends IService<ApUserRealname> {
    /**
     * 按照状态查询用户认证列表
     * @param dto
     * @return
     */
    public ResponseResult loadListByStatus(AuthDto dto);

    /**
     * 修改认证用户状态
     * @param dto
     * @param status
     * @return
     */
    public ResponseResult updateStatusById(AuthDto dto,Short status);
}
