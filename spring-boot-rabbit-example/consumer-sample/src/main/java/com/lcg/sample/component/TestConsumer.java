package com.lcg.sample.component;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestConsumer {
    @RabbitListener(queues = "test-mqs")
    @RabbitHandler
    public void handler(Message msg){
        log.info("收到消息:{}", JSON.parse((byte[]) msg.getPayload()));
    }

}

