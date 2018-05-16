package com.csc.learn.bootserver;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by LiHuan on 2018/5/16 0016.
 */
public class SpringBootWebServerThird extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootWebServer.class);
    }
}
