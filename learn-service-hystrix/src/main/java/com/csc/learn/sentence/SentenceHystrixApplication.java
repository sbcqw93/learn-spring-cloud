package com.csc.learn.sentence;

import com.csc.learn.feign.SubjectFeignClient;
import com.csc.learn.service.WordService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rx.Subscriber;

import java.util.List;

/**
 * Hello world!<br>
 * 使用Hystrix访问另一个服务API
 */
@EnableFeignClients(basePackages = "com.csc.learn")
@ComponentScan(value = "com.csc.learn.service")
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
//@EnableDiscoveryClient
public class SentenceHystrixApplication {

    @Autowired
    private WordService wordService;

    @ResponseBody
    @RequestMapping("/")
    public String getSentence() {
        final List<String> nounList = Lists.newArrayList();
        wordService.getNoun2().subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                nounList.add(s);
            }
        });
        try {
            return String.format("%s-->%s-->%s-->%s || %s-->%s", wordService.getSubject(), wordService.getVerb(), wordService.getAdjective(), wordService.getNoun(), nounList.get(0), wordService.getSubject2().get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "System errors";
    }


    public static void main(String[] args) {
        SpringApplication.run(SentenceHystrixApplication.class, args);
    }
}
