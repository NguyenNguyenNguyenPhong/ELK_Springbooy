package com.lemoncode21.ELK_SpringBoot.controller;//package com.example.demo.controller;// LogController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public LogController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String postLog(@RequestBody String logMessage) {
        // Gửi log message lên Kafka
        kafkaTemplate.send("logs", logMessage);

        // Trả về thông báo thành công
        return "Log sent to Kafka: " + logMessage;
    }
}
