package com.csc.learn.bootserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
public class SpringBootWebServer {

    @ResponseBody
    @RequestMapping("/")
    public String show(){
        return "Hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebServer.class, args);
    }
}
