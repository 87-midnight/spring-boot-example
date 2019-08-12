package com.lcg.example.service;

import com.alibaba.fastjson.JSON;
import com.lcg.example.EchoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;


@Service
@Slf4j
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String... params) {
        log.info("nacos echoService print:{}", JSON.toJSONString(params));
        return JSON.toJSONString(params);
    }
}
