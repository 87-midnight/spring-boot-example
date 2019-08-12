package com.lcg.example;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class ZkConsumerApplication {

    @Reference
    private EchoService echoService;

    public static void main(String...args){
        SpringApplication.run(ZkConsumerApplication.class,args);
    }

    @Bean
    public ApplicationRunner exec(){
        return args -> log.info("consumer exec:{}",echoService.echo("hello","I'm a consumer"));
    }
}
