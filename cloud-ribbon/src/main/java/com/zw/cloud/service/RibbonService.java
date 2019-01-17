package com.zw.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallBack")
    public String EurekaClientService() {
        return restTemplate.getForObject("http://eureka-client1/hi", String.class);
    }

    public String fallBack() {
        return "fallBack，error";
    }
}
