package com.oreilly.integration;

import org.springframework.messaging.Message;

import java.util.concurrent.Future;

public interface PrinterGateway {
    Future<Message<String>> print(Message<?> message);
//    Message<String> print(Message<?> message);
}
