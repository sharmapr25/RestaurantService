package food.service.demo.service;

import food.service.demo.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagePublisher {
    @Value(value = "${spring.kafka.template.default-topic}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, Restaurant> kafkaTemplate;

    public void publishMessage(Restaurant restaurant) {
        kafkaTemplate.send(topicName, restaurant);
    }
}
