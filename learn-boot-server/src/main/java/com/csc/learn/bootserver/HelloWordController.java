package com.csc.learn.bootserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LiHuan on 2018/5/16 0016.
 */
@RestController
public class HelloWordController {
    @ResponseBody
    @RequestMapping("/u")
    public String show(){
        return "Hello world/u";
    }
}
