package com.oreilly.integration;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

public class CustomFilter implements MessageSelector {

    @Override
    public boolean accept(Message<?> message) {
        return Integer.parseInt(message.getPayload().toString()) % 2 == 0;
    }
}
