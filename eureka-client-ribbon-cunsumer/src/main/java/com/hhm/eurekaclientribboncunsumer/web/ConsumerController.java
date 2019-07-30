package com.hhm.eurekaclientribboncunsumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author houhaimin
 * @version 1.0
 * @date 2019/7/28 19:38
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String test(){
        return restTemplate.getForEntity("http://EUREKA-CLIENT/hello/sayHello",String.class).getBody();
    }
}
