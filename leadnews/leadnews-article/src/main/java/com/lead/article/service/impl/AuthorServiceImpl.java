package com.lead.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lead.article.mapper.AuthorMapper;
import com.lead.article.service.AuthorService;
import com.lead.model.article.pojo.ApAuthor;
import org.springframework.stereotype.Service;

/**
 * @ClassName AuthorServiceImpl
 * @date 2021/5/24 20:09
 * @Version 1.0
 * @Author ShyBoy
 */
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, ApAuthor> implements AuthorService {
}
