package com.oreilly.integration;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class PrintService {
    public void print(Message<String> message) {
        MessageHeaders headers = message.getHeaders();
        headers.forEach((key, value) -> System.out.printf("key: %s%nvalue: %s%n", key, value));
        System.out.println(message.getPayload());
    }
}
