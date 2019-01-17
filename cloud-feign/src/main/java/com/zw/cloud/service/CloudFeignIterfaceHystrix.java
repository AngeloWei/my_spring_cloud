package com.zw.cloud.service;

import org.springframework.stereotype.Component;

@Component
public class CloudFeignIterfaceHystrix implements CloudFeignInterface {

    @Override
    public String feignHi() {
        return "sorry,feign hystric";
    }
}
