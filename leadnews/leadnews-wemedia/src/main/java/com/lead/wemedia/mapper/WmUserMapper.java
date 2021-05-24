package com.lead.wemedia.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lead.model.media.pojo.WmUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName WmUserMapper
 * @date 2021/5/24 19:06
 * @Version 1.0
 * @Author ShyBoy
 */
@Mapper
public interface WmUserMapper extends BaseMapper<WmUser> {
}
