package com.hhm.eurekaclientribboncunsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author houhaimin
 * @version 1.0
 * @date 2019/8/11 15:44
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloString(String name){
        return restTemplate.getForEntity("http://EUREKA-CLIENT/hello/sayHello",String.class).getBody();
    }

    public String helloFallback(String name){
        return "error";
    }

}
