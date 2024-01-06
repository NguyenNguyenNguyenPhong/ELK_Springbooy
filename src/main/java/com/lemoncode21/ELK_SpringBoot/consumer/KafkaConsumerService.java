package com.lemoncode21.ELK_SpringBoot.consumer;

import com.lemoncode21.ELK_SpringBoot.controller.DemoController;
import com.lemoncode21.ELK_SpringBoot.controller.KafkaProducerController;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@Slf4j
public class KafkaConsumerService {

    private final String kafkaTopic = "Topic_1_Test";
//    private final Logger logger =(Logger) LoggerFactory.getLogger(KafkaConsumerService.class);
    @KafkaListener(topics = kafkaTopic, groupId = "my-group-id")
    public void listen(ConsumerRecord<String, String> record) {
        // Xử lý thông điệp từ Kafka
        log.info("Consumer message is value "+record.value() );
        System.out.println("Received Message: " + record.value());
    }
}
