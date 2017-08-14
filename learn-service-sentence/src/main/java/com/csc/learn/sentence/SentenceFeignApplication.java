package com.csc.learn.sentence;

import com.csc.learn.service.SubjectFeignClient;
import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Hello world!<br>
 *  使用Feign访问另一个服务API
 */
@EnableFeignClients(basePackages = "com.csc.learn")
@SpringBootApplication
@EnableEurekaClient
@RestController
//@EnableDiscoveryClient
public class SentenceFeignApplication {

    private String username = "user";
    private String password = "123456";

    @Autowired
    //private DiscoveryClient discoveryClient;
    //private LoadBalancerClient loadBalancerClient;
    private SubjectFeignClient subjectFeignClient;

    @ResponseBody
    @RequestMapping("/")
    public String getSentence() {
       // StringBuffer buffer = new StringBuffer();
       // buffer.append(getWord()).append("==>");
       // buffer.append(getWord());
       // return buffer.toString();
        try {
            return subjectFeignClient.getWord();
        }catch (Exception e){
            e.printStackTrace();
            return "Exception invoke feign interfaces.";
        }
    }

    //public String getWord() {
    //    try {
    //        return subjectFeignClient.getWord();
    //    }catch (Exception e){
    //        e.printStackTrace();
    //        return "Exception invoke feign interfaces.";
    //    }
    //}

    public static void main(String[] args) {
        SpringApplication.run(SentenceFeignApplication.class, args);
    }
}
