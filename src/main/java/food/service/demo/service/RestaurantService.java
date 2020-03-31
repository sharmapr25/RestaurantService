package food.service.demo.service;

import food.service.demo.entity.Restaurant;
import food.service.demo.exception.RestaurantAlreadyExistsException;
import food.service.demo.repository.RestaurantRepository;
import food.service.demo.web_api_contract.CreateRestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public Restaurant create(CreateRestaurantRequest restaurantRequest) {
        Restaurant restaurantByName = restaurantRepository.findRestaurantByName(restaurantRequest.getName());
        if(restaurantByName != null){
            throw new RestaurantAlreadyExistsException();
        }

        Restaurant restaurant = new Restaurant(restaurantRequest.getName(), restaurantRequest.getMenu());
        return restaurantRepository.save(restaurant);
    }
}
