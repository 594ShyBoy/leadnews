package com.lead.wemedia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lead.model.media.pojo.WmUser;
import com.lead.wemedia.mapper.WmUserMapper;
import com.lead.wemedia.service.WmUserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName WmUserServiceImpl
 * @date 2021/5/24 19:07
 * @Version 1.0
 * @Author ShyBoy
 */
@Service
public class WmUserServiceImpl extends ServiceImpl<WmUserMapper, WmUser> implements WmUserService {
}
