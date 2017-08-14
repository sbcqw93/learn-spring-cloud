package com.csc.learn.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class MineEurekaServerApplication {
    public static void main( String[] args ) {
        SpringApplication.run(MineEurekaServerApplication.class, args);
    }
}
