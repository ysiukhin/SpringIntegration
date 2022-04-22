package com.oreilly.integration;

import org.springframework.messaging.Message;

import java.util.Comparator;

public class CustomMessageComparator implements Comparator<Message<String>> {

    @Override
    public int compare(Message<String> message1, Message<String> message2) {
        String payload1 = message1.getPayload();
        String payload2 = message2.getPayload();
        boolean isPayload1Even = Integer.parseInt(payload1.substring(payload1.length()-1)) % 2 == 0;
        boolean isPayload2Even = Integer.parseInt(payload2.substring(payload1.length()-1)) % 2 == 0;

        if((isPayload1Even && isPayload2Even) || (!isPayload1Even && !isPayload2Even)) {
            return 0;
        } else if(isPayload1Even) {
            return -1;
        }
        return 1;
    }
}
