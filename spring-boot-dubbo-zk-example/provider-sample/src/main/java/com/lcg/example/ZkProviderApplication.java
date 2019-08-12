package com.lcg.example;

import com.lcg.example.embedded.EmbeddedZooKeeper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ZkProviderApplication {

    public static void main(String...args){
        // 这里单独起一个内置的zookeeper 服务，这样子是不带有集群功能。
        //如果想使用独立的zookeeper，则注释掉SpringApplicationBuilder的代码，还原最后一行代码即可
        new SpringApplicationBuilder(ZkProviderApplication.class)
                .listeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
                    Environment environment = event.getEnvironment();
                    int port = environment.getProperty("embedded.zookeeper.port", int.class);
                    new EmbeddedZooKeeper(port, false).start();
                })
                .run(args);
//        SpringApplication.run(ZkProviderApplication.class,args);
    }
}
