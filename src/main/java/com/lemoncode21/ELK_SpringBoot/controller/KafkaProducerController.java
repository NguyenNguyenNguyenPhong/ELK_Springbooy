package com.lemoncode21.ELK_SpringBoot.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
@Slf4j
public class KafkaProducerController {
//    private final Logger logger = (Logger) LoggerFactory.getLogger(KafkaProducerController.class);
    private final String kafkaTopic = "Topic_1_Test";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody String message) {
        // Gửi message lên Kafka topic
        log.info("Post Message to kaffka í value " + message);
        kafkaTemplate.send(kafkaTopic, message);
    }
}
