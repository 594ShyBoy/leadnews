package com.lead.wemedia.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.common.enums.AppHttpCodeEnum;
import com.lead.model.media.dto.WmUserDto;
import com.lead.model.media.pojo.WmUser;
import com.lead.utils.common.AppJwtUtil;
import com.lead.wemedia.mapper.WmUserMapper;
import com.lead.wemedia.service.WmUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName WmUserServiceImpl
 * @date 2021/5/24 19:07
 * @Version 1.0
 * @Author ShyBoy
 */
@Service
public class WmUserServiceImpl extends ServiceImpl<WmUserMapper, WmUser> implements WmUserService {
    @Override
    public ResponseResult login(WmUserDto dto) {



        //1. 检查参数
        if (StringUtils.isEmpty(dto.getName()) || StringUtils.isEmpty(dto.getPassword())){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID,"用户或密码错误!");

        }
        //2. 查询数据库中的用户信息
        List<WmUser> list = list(Wrappers.<WmUser>lambdaQuery().eq(WmUser::getName, dto.getName()));
        System.out.println(list);
        if (list != null &&list.size() == 1){
            WmUser wmUser = list.get(0);
            //3. 比对密码
            String pswd = DigestUtils.md5DigestAsHex((dto.getPassword() + wmUser.getSalt()).getBytes());
            System.out.println(wmUser.getSalt());
            System.out.println(pswd);
            if (wmUser.getPassword().equals(pswd)){
                System.out.println(wmUser.getPassword());
                //4. 返回数据jwt
                HashMap<String, Object> map = new HashMap<>();
                map.put("token", AppJwtUtil.getToken(wmUser.getId().longValue()));
                wmUser.setPassword("");
                wmUser.setSalt("");
                map.put("user",wmUser);
                return ResponseResult.okResult(map);
            }else{
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }
        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST,"用户不存在");
        }

    }
}
