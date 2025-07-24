package com.devin.kafka_demo.controller;


import com.devin.kafka_demo.service.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class SendMessageController {

    private final KafkaProducer producer;

    public SendMessageController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestParam String message) {
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka: " + message);
    }
}