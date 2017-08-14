package com.csc.learn.sentence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
//@EnableDiscoveryClient
public class SentenceApplication {

    private String username = "user";
    private String password = "123456";

    @Autowired
    private DiscoveryClient discoveryClient;

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
            System.out.println("=======================all services: " + discoveryClient.getServices());
            List<ServiceInstance> list = discoveryClient.getInstances(service);
            System.out.println("=======================service instance size: " + list.size());
            if (list != null && list.size() > 0) {
                URI uri = list.get(0).getUri();
                if (uri != null) {
                    RestTemplate restTemplate  = null;
                    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
                    restTemplate = restTemplateBuilder.basicAuthorization(username, password).build();
                    return restTemplate.getForObject(uri, String.class);
                    // return (new RestTemplate()).getForObject(uri, String.class);
                }
            }
            return "Not found service instance.";
        }catch (Exception e){
            e.printStackTrace();
            return "Exception found service instance.";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SentenceApplication.class, args);
    }
}
