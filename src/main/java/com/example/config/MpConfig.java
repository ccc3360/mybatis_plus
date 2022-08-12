package com.example.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//或者在启动类中导入
public class MpConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
//        1、定义mp拦截器
        MybatisPlusInterceptor mybatisPlusInterceptor=new MybatisPlusInterceptor();

//        2、在mp拦截器中添加具体的拦截器
//           分页拦截器
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

//           乐观锁拦截器
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mybatisPlusInterceptor;
    }

}
