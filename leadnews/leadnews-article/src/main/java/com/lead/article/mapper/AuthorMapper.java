package com.lead.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lead.model.article.pojo.ApAuthor;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName AuthorMapper
 * @date 2021/5/24 20:06
 * @Version 1.0
 * @Author ShyBoy
 */
@Mapper
public interface AuthorMapper extends BaseMapper<ApAuthor> {
}
