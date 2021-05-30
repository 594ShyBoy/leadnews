package com.lead.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lead.model.user.pojo.ApUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName ApUserMapper
 * @date 2021/5/24 20:20
 * @Version 1.0
 * @Author ShyBoy
 */
@Mapper
public interface ApUserMapper extends BaseMapper<ApUser> {
}
