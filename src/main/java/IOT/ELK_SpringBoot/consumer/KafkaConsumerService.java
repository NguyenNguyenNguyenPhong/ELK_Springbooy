package IOT.ELK_SpringBoot.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Logger;

@Service
@Slf4j
public class KafkaConsumerService {

    private static final String API_URL = "http://172.20.10.12/Test";
    private final String kafkaTopic = "Topic_1_Test";
//    private final Logger logger =(Logger) LoggerFactory.getLogger(KafkaConsumerService.class);
    @KafkaListener(topics = kafkaTopic, groupId = "my-group-id")
    public void listen(ConsumerRecord<String, String> record) {
        // Xử lý thông điệp từ Kafka
        log.info("Consumer message is value "+record.value() );
        callApiWithParameter(record.value());
        System.out.println("Received Message: " + record.value());
    }

    public String callApiWithParameter(String name) {
        // Tạo một đối tượng RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Xây dựng URL với tham số
        String urlWithParameter = API_URL + "?name=" + name;

        // Gọi API với method GET và lấy kết quả về dưới dạng String
        String result = restTemplate.getForObject(urlWithParameter, String.class);

        // Xử lý kết quả nếu cần thiết
        // ...

        return result;
    }

}
