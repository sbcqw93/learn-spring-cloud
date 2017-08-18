package com.csc.learn.sentence;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 配置文件更新了，使用PostMan进行POST请求：http://localhost:8089/bus/refresh
 */

/**
 *  refreshScope方式
 *  18,37s/^/\/\//g  ====>    18,37s/^\/\///g
 */
//@SpringBootApplication
//@EnableEurekaClient
//@RestController
//@EnableDiscoveryClient
//@RefreshScope
//public class SentenceBusApplication {
//
//    @Value("${bar}")
//    private String bar;
//
//    @ResponseBody
//    @RequestMapping("/bar")
//    public String shwoBar() {
//        return "变量bar的值是：" + bar;
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(SentenceBusApplication.class, args);
//    }
//}

/**
 *  ConfigurationProperties方式
 *  43,70s/^/\/\//g  ====>    43,70s/^\/\///g
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableDiscoveryClient
@ConfigurationProperties()
public class SentenceBusApplication {

    @Value("${bar}")
    private String bar;

    @ResponseBody
    @RequestMapping("/bar")
    public String showBar() {
        return "变量bar的值是：" + bar;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public static void main(String[] args) {
        SpringApplication.run(SentenceBusApplication.class, args);
    }
}
