package com.lead.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lead.admin.mapper.AdChannelMapper;
import com.lead.admin.service.AdChannelService;
import com.lead.model.admin.dto.ChannelDto;
import com.lead.model.admin.pojo.AdChannel;
import com.lead.model.common.dtos.PageResponseResult;
import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.common.enums.AppHttpCodeEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName AdChannelServiceImpl
 * @date 2021/5/20 23:39
 * @Version 1.0
 * @Author ShyBoy
 */
@Service
public class AdChannelServiceImpl extends ServiceImpl<AdChannelMapper, AdChannel> implements AdChannelService {
    @Override
    public ResponseResult findByNameAndPage(ChannelDto dto) {
        //1. 检查参数
        if (null == dto){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        dto.checkParam();

        //2. 根据名称模糊分页查询
        Page page = new Page(dto.getPage(), dto.getSize());
        LambdaQueryWrapper<AdChannel> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(dto.getName())){
            lambdaQueryWrapper.like(AdChannel::getName,dto.getName());
        }
        IPage result = page(page, lambdaQueryWrapper);

        //3. 结果返回 ResponseResult
        PageResponseResult responseResult = new PageResponseResult(dto.getPage(), dto.getSize(), (int) result.getTotal());
        responseResult.setData(result.getRecords());


        return responseResult;
    }

    @Override
    public ResponseResult insert(AdChannel adChannel) {
        //1. 检查参数
        if (null == adChannel){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }

        //2. 执行保存
        adChannel.setCreatedTime(new Date());
        save(adChannel);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult update(AdChannel adChannel) {
        //1. 检查参数
        if (null == adChannel || adChannel.getId() == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //2. 修改
        updateById(adChannel);

        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult deleteById(Integer id) {
        //1. 检查参数
        if (id == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        AdChannel adChannel = getById(id);
        if (adChannel == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        if (adChannel.getStatus()){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID,"频道有效无法删除");
        }

        //2. 执行删除
        removeById(id);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }


}
