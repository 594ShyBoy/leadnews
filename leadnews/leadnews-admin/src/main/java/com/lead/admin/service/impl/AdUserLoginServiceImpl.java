package com.lead.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.lead.admin.mapper.AdUserLoginMapper;
import com.lead.admin.service.AdUserLoginService;
import com.lead.model.admin.dto.AdUserDto;
import com.lead.model.admin.pojo.AdUser;
import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.common.enums.AppHttpCodeEnum;
import com.lead.utils.common.AppJwtUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AdUserLoginServiceImpl
 * @date 2021/5/24 17:01
 * @Version 1.0
 * @Author ShyBoy
 */
@Service
public class AdUserLoginServiceImpl extends ServiceImpl<AdUserLoginMapper, AdUser> implements AdUserLoginService {
    @Override
    @Transactional
    public ResponseResult login(AdUserDto dto) {
        //1. 参数校验
        if (StringUtils.isEmpty(dto.getName()) || StringUtils.isEmpty(dto.getPassword())){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE,"用户名或密码不能为空!");

        }
        //2. 查询数据库中的用户信息
        /*QueryWrapper wrapper = new QueryWrapper<AdUser>();
        wrapper.eq("name",dto.getName());
        List<AdUser> list = list(wrapper);*/

        List<AdUser> list = list(Wrappers.<AdUser>lambdaQuery().eq(AdUser::getName, dto.getName()));

        //System.out.println(list);
        if (list != null && list.size() == 1){
            System.out.println(list);
            //用户存在且唯一
            AdUser adUser = list.get(0);
            String pswd = DigestUtils.md5DigestAsHex((dto.getName() + adUser.getSalt()).getBytes());
            if (adUser.getPassword().equals(pswd)){
                //密码正确
                Map<String,Object> map = Maps.newHashMap();
                adUser.setPassword("");
                adUser.setSalt("");
                map.put("token", AppJwtUtil.getToken(adUser.getId().longValue()));
                map.put("user",adUser);
                return ResponseResult.okResult(map);
            }else{
                //密码不正确
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }
        }else{
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST,"用户不存在!");
        }
    }
}
