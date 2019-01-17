package com.zw.cloud.controller;

import com.zw.cloud.service.CloudFeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private CloudFeignInterface feignInterface;
    @GetMapping("/test/feign1")
    public String testFeignClient1() {
        return feignInterface.feignHi()+"==========feign1";
    }
    @GetMapping("/test/feign2")
    public String testFeignClient2() {
        return feignInterface.feignHi()+"==========feign2";
    }
}
