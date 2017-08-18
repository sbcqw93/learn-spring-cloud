package com.csc.learn.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lihuan on 2017/8/16.
 */
@FeignClient(name = "learn-eureka-client-verb", configuration = MineConfiguration.class)
public interface VerbFeignClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getWord() ;
}
