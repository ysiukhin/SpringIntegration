package com.oreilly.integration;

import org.springframework.messaging.Message;

public class PrintService {
    public void print(Message<String> message) {
        throw new RuntimeException("PrintService throws an exception.");
        //        System.out.println(message.getPayload());
    }
}
