package com.oreilly.integration;

import org.springframework.messaging.Message;

import java.util.Arrays;
import java.util.List;

public class CustomSplitter {

    public List<String> split(Message<?> message) {
        return Arrays.asList(message.getPayload().toString().split(" "));
    }
}
