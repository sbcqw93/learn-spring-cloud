package com.csc.learn.feign;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lihuan on 2017/8/14.
 */
@Configuration
public class MineConfiguration {

    //@Bean
    //public Contract feignContract() {
    //    return new feign.Contract.Default();
    //}

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "123456");
    }
}
