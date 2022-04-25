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
    private EnhancedPrinterGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Person[] payloads =
                {
                    new Person("Kevin","Bowersox"),
                    new Person("Yuriy", "Siukhin")
                };

//        for (int x = 0; x < payloads.length; x++) {
//            Message<?> message = MessageBuilder.withPayload(payloads[x]).setHeader("replyChannel", "outputChannel")
//                    .build();
//            this.gateway.print(message);
//        }
        for (Person payload : payloads) {
            String returnedMessage = this.gateway.uppercase(payload);
            System.out.println(returnedMessage);
        }
    }
}
