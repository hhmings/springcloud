package com.hhm.eurekaclient.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author houhaimin
 * @version 1.0
 * @date 2019/7/21 15:51
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient client;//服务发现客户端
    @RequestMapping("/sayHello")
    public String sayHello(){
        List<ServiceInstance> instances = client.getInstances("eureka-client");
        ServiceInstance serviceInstance = instances.get(0);
        log.info("host:"+serviceInstance.getHost()+" , port:"+serviceInstance.getPort()
                +" , service_id:"+serviceInstance.getServiceId());
        return "hello";
    }

}
