package com.csc.learn.sentence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Hello world!<br>
 *  使用Ribbon（负载均衡）访问另一个服务API
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableDiscoveryClient
public class SentenceRibbonApplication {

    private String username = "user";
    private String password = "123456";

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @ResponseBody
    @RequestMapping("/")
    public String getSentence() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getWord("learn-eureka-client-subject")).append("==>");
        buffer.append(getWord("learn-eureka-client-verb"));
        return buffer.toString();
    }

    public String getWord(String service) {
        try {
            ServiceInstance serviceInstance = loadBalancerClient.choose(service);
            URI uri = serviceInstance.getUri();
            if (uri != null) {
                RestTemplate restTemplate  = null;
                RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
                restTemplate = restTemplateBuilder.basicAuthorization(username, password).build();
                return restTemplate.getForObject(uri, String.class);
            }
            return "Not found service instance.";
        }catch (Exception e){
            e.printStackTrace();
            return "Exception found service instance.";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SentenceRibbonApplication.class, args);
    }
}
