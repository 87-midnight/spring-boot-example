package com.lcg.sample.component;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Bean
    public CommandLineRunner send(){
        Map<String,Object> map = new HashMap<>();
        map.putIfAbsent("name","xiaohong");
        map.putIfAbsent("gender","female");
        return (args)->{
            try {

                while (true){
                    Thread.sleep(3000);
                    map.put("timestamp",System.currentTimeMillis());
                    amqpTemplate.convertAndSend("test-mqs", JSON.toJSONBytes(map));
                }
            }catch (Exception var1){

            }
        };
    }
}
