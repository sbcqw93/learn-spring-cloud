package com.csc.learn.sentence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.servlet.Filter;

/**
 * Hello world!<br>
 * 使用Zuul
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableDiscoveryClient

@EnableZuulProxy
public class SentenceZuulApplication {

    @Bean
    public Filter shallowEtagHeaderFilter(){
        return new ShallowEtagHeaderFilter();
    }

    /**服务关闭身份认证是可以通过zuul进行访问的，但开启还不行*/

    //@Bean
    //public Filter basicAuthenticationFilter(){
    //    AuthenticationManager authenticationManager = null;
    //    return new BasicAuthenticationFilter(authenticationManager);
    //}

    //@Bean
    //public Filter usernamePasswordAuthenticationFilter() throws Exception {
    //    UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter = new UsernamePasswordAuthenticationFilter();
    //    usernamePasswordAuthenticationFilter.setUsernameParameter("user");
    //    usernamePasswordAuthenticationFilter.setPasswordParameter("123456");
    //    usernamePasswordAuthenticationFilter.setAuthenticationManager(new AuthenticationConfiguration().getAuthenticationManager());
    //    return usernamePasswordAuthenticationFilter;
    //}

    public static void main(String[] args) {
        SpringApplication.run(SentenceZuulApplication.class, args);
    }
}
