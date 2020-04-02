package food.service.demo.service;

import food.service.demo.entity.Restaurant;
import food.service.demo.repository.RestaurantRepository;
import food.service.demo.web_api_contract.CreateRestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    KafkaMessagePublisher kafkaMessagePublisher;

    @Autowired
    RestaurantRepository restaurantRepository;

    public Restaurant create(CreateRestaurantRequest restaurantRequest) {
        Restaurant restaurant = new Restaurant(restaurantRequest.getName(), restaurantRequest.getMenu());
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        kafkaMessagePublisher.publishMessage(savedRestaurant);
        return savedRestaurant;
    }
}
