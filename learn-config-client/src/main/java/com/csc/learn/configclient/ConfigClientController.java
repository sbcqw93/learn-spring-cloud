package com.csc.learn.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lihuan on 2017/8/10.
 */
@RestController
public class ConfigClientController {

    @Value("${bar}")
    private String bar;

    @ResponseBody
    @RequestMapping("/bar")
    public String shwoBar() {
        return "变量bar的值是：" + bar;
    }
}
