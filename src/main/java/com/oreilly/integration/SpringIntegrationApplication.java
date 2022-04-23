package com.oreilly.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.support.GenericMessage;
import sun.jvm.hotspot.runtime.Thread;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationApplication implements ApplicationRunner {

    @Autowired
    private PrinterGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Message<?> message;
//            if(i % 2 == 0) {
//                message = MessageBuilder.withPayload("Printing message payload for " + i)
//                        .setHeader("routeHeader", "string")
//                        .build();
//            }
//            else {
//                message = MessageBuilder.withPayload(i)
//                        .setHeader("routeHeader", "int")
//                        .build();
//            }
                message = MessageBuilder.withPayload(i)
                        .setHeader("routeHeader", "int")
                        .build();

            this.gateway.print(message);
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }
}
