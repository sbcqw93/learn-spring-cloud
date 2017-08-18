package com.csc.learn.sentence;

import com.csc.learn.feign.SubjectFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private SubjectFeignClient subjectFeignClient;

    @ResponseBody
    @RequestMapping("/")
    public String getSentence() {
        try {
            return subjectFeignClient.getWord();
        }catch (Exception e){
            e.printStackTrace();
            return "Exception invoke feign interfaces.";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SentenceFeignApplication.class, args);
    }
}
