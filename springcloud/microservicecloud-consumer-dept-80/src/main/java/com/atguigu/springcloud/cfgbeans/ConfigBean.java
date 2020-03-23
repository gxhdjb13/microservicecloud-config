package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced  //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端 负载均衡的工具.
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    //随机机制
//    @Bean
//    public IRule myRule(){
//        return new RandomRule();//用我们选择的随机算法替代默认的轮询
//    }
    //重试机制
    @Bean
    public IRule myRule(){
        return new RetryRule();
    }
}
