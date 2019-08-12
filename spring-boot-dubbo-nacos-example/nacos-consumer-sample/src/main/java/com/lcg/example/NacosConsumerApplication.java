package com.lcg.example;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class NacosConsumerApplication {

    @Reference
    private EchoService echoService;
    @Reference
    private UserService userService;

    public static void main(String...args){
        SpringApplication.run(NacosConsumerApplication.class,args);
    }

    @Bean
    public ApplicationRunner echo(){
        return args -> log.info("nacos consumer exec:{}",echoService.echo("hello","nacos provider,this is echoService calling"));
    }
    @Bean
    public ApplicationRunner print(){
        return args -> log.info("nacos consumer exec:{}",userService.print("hello,nacos provider,my name is userService"));
    }
}
