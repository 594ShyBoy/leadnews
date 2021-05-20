package com.lead.admin;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName AdminApplication
 * @date 2021/5/20 22:49
 * @Version 1.0
 * @Author ShyBoy
 */
@SpringBootApplication
@MapperScan("com.lead.admin.mapper")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }
    /**
     *  mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
