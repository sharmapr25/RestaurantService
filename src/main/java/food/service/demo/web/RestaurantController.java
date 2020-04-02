package food.service.demo.web;

import food.service.demo.entity.Restaurant;
import food.service.demo.service.RestaurantService;
import food.service.demo.web_api_contract.CreateRestaurantRequest;
import food.service.demo.web_api_contract.CreateRestaurantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping
    public CreateRestaurantResponse create(@RequestBody CreateRestaurantRequest request){
        Restaurant restaurant = restaurantService.create(request);
        return new CreateRestaurantResponse(restaurant.getId());
    }
}
