package com.zw.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "eureka-client1",fallback =CloudFeignIterfaceHystrix.class )
public interface CloudFeignInterface {

    @RequestMapping("/hi")
    String feignHi();
}
