package com.lead.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lead.model.common.dtos.PageResponseResult;
import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.common.enums.AppHttpCodeEnum;
import com.lead.model.user.dtos.AuthDto;
import com.lead.model.user.pojo.ApUserRealname;
import com.lead.user.mapper.ApUserRealnameMapper;
import com.lead.user.service.ApUserRealnameService;
import org.springframework.stereotype.Service;

/**
 * @ClassName ApUserRealnameServiceImpl
 * @date 2021/5/23 8:20
 * @Version 1.0
 * @Author ShyBoy
 */
@Service
public class ApUserRealnameServiceImpl extends ServiceImpl<ApUserRealnameMapper, ApUserRealname> implements ApUserRealnameService {
    @Override
    public ResponseResult loadListByStatus(AuthDto dto) {
        //参数为空
        if (dto == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //检查参数
        dto.checkParam();
        LambdaQueryWrapper<ApUserRealname> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (dto.getStatus() != null){
            lambdaQueryWrapper.eq(ApUserRealname::getStatus,dto.getStatus());
        }
        IPage pageParam =  new Page(dto.getPage(),dto.getSize());
        IPage page = page(pageParam,lambdaQueryWrapper);
        PageResponseResult responseResult = new PageResponseResult(dto.getPage(), dto.getSize(), (int) page.getTotal());
        //responseResult.setCode(0);
        responseResult.setData(page.getRecords());
        return responseResult;
    }
}
