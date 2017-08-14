package com.csc.learn.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
//@EnableDiscoveryClient
public class MineEurekaClientApplication {

    @Value("${bar}")
    private String bar;

    @Value("${uname}")
    private String uname;

    @Value("${words}")
    private String words;

    @ResponseBody
    @RequestMapping("/show")
    public String show() {
        return String.format("变量uname=%s, 变量bar=%s", uname, bar);
    }

    @ResponseBody
    @RequestMapping("/")
    public String getWord(){
        String[] wordArray = words.split(",");
        int i = (int)Math.round(Math.random() * (wordArray.length - 1));
        return wordArray[i];
    }

    public static void main( String[] args ) {
        SpringApplication.run(MineEurekaClientApplication.class, args);
    }
}
