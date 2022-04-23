package com.oreilly.integration;

import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.aggregator.AbstractAggregatingMessageGroupProcessor;
import org.springframework.integration.store.MessageGroup;
import org.springframework.messaging.Message;

import java.util.Map;

public class CustomAggregator extends AbstractAggregatingMessageGroupProcessor {
    @Override
    protected Object aggregatePayloads(MessageGroup group, Map<String, Object> defaultHeaders) {
        StringBuilder builder = new StringBuilder();
        for (Message<?> msg : group.getMessages()) {

            System.out.println(
                    msg.getHeaders().get(IntegrationMessageHeaderAccessor.CORRELATION_ID)
            );

            builder.append(msg.getPayload());
        }
        return builder.toString();
    }
}
