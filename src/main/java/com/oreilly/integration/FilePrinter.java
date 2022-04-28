package com.oreilly.integration;

import org.springframework.messaging.Message;

import java.io.*;

public class FilePrinter {

//    public void print(Message<?> message) {
//        System.out.println("Printing the message:");
//        System.out.println(message);
//    }

    public String print(Message<?> message) {
        return "From the inbound gateway: 1 message worked";
    }

    public void printConsole(Message<?> message) {
        System.out.println("Message was passed to printConsole from the outboundGateway");
        System.out.println(message);
    }

//    public void print(String file) {
//        System.out.println("Invoking the print method with a string");
//        System.out.println(file);
//    }

    public void print(File file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
