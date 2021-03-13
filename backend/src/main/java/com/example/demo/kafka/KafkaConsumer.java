package com.example.demo.kafka;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumer {
    
    @KafkaListener(topics = "test", groupId = "group_id")
    public String consume(String message) throws IOException {
        return message;
    }
}
