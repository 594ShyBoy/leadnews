package com.lead.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lead.admin.mapper.AdSensitiveMapper;
import com.lead.admin.service.AdSensitiveService;
import com.lead.model.admin.dto.SensitiveDto;
import com.lead.model.admin.pojo.AdSensitive;
import com.lead.model.common.dtos.PageResponseResult;
import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.common.enums.AppHttpCodeEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName AdSensitiveServiceImpl
 * @date 2021/5/21 23:58
 * @Version 1.0
 * @Author ShyBoy
 */
@Service
public class AdSensitiveServiceImpl extends ServiceImpl<AdSensitiveMapper, AdSensitive> implements AdSensitiveService {
    @Override
    public ResponseResult list(SensitiveDto dto) {
        //1. 检查参数
        if (dto == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        dto.checkParam();
        //2.根据名称模糊分页查询
        Page page = new Page<>(dto.getPage(), dto.getSize());
        LambdaQueryWrapper<AdSensitive> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(dto.getName())){
            lambdaQueryWrapper.like(AdSensitive::getSensitives,dto.getName());
        }

        IPage result = page(page, lambdaQueryWrapper);
        //3. 结果返回
        PageResponseResult responseResult = new PageResponseResult(dto.getPage(), dto.getSize(), (int) result.getTotal());
        responseResult.setData(result.getRecords());
        return responseResult;
    }

    @Override
    public ResponseResult insert(AdSensitive adSensitive) {
        //1. 检查参数
        if (adSensitive == null){
            return ResponseResult.errorResult((AppHttpCodeEnum.PARAM_INVALID));
        }
        //2. 执行保存
        adSensitive.setCreatedTime(new Date());
        adSensitive.setSensitives(adSensitive.getSensitives());
        System.out.println(adSensitive.getSensitives());
        save(adSensitive);

        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult update(AdSensitive adSensitive) {
        //1. 检查参数
        if (adSensitive == null || adSensitive.getId() == null){
            return ResponseResult.errorResult((AppHttpCodeEnum.PARAM_INVALID));
        }
        //2. 执行修改
        updateById(adSensitive);

        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }


    @Override
    public ResponseResult deleteById(Integer id) {
        //1. 检查参数
        if (id == null){
            return ResponseResult.errorResult((AppHttpCodeEnum.PARAM_INVALID));
        }
        AdSensitive adSensitive = getById(id);
        if (adSensitive == null){
            return ResponseResult.errorResult((AppHttpCodeEnum.DATA_NOT_EXIST));
        }
        //3. 执行删除
        removeById(id);

        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}
