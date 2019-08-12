package com.lcg.example.service;

import com.lcg.example.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public String print(String param) {
        log.info("receive param from provider:{}",param);
        return "provider had been executed this method successfully";
    }
}
