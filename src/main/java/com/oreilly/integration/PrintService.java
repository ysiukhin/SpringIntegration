package com.oreilly.integration;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class PrintService {
    public void print(Message<?> message) {
            System.out.println(message.getPayload());
        message.getHeaders()
                .forEach((s, o) -> System.out.println(s + ":" + o));
    }
}
