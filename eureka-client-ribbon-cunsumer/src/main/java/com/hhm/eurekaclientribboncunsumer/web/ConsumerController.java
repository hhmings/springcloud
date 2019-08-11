package com.hhm.eurekaclientribboncunsumer.web;

import com.hhm.eurekaclientribboncunsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author houhaimin
 * @version 1.0
 * @date 2019/7/28 19:38
 */
@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/test")
    public String test(){
        return helloService.helloString("aaa");
    }
}
