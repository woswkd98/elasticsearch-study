package com.example.demo.kafka;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;


//https://www.elastic.co/kr/blog/just-enough-kafka-for-the-elastic-stack-part1 본 문서
public class KafkaConsumer {
    
    @KafkaListener(topics = "test", groupId = "group_id")
    public String consume(String message) throws IOException {
        return message;
    }
}
