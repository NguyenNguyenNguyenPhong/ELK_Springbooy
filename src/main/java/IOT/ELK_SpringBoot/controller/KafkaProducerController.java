package IOT.ELK_SpringBoot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

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

    @PostMapping("/ESP32Cams")
    public void handlePostRequest(@RequestBody String inputString) {
        log.info("Hello endpoint is accessed!" +inputString);
    }

}
