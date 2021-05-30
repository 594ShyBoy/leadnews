package com.lead.article.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ExceptionConfig
 * @date 2021/5/21 8:39
 * @Version 1.0
 * @Author ShyBoy
 * 全局异常处理器
 */
@Configuration
@ComponentScan("com.lead.common.exception")
public class ExceptionConfig {

}
