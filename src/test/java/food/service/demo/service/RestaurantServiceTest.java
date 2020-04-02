package food.service.demo.service;

import food.service.demo.entity.MenuItem;
import food.service.demo.entity.Restaurant;
import food.service.demo.repository.RestaurantRepository;
import food.service.demo.web_api_contract.CreateRestaurantRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantServiceTest {

    @Mock
    RestaurantRepository restaurantRepository;


    @InjectMocks
    RestaurantService restaurantService;

    @Test
    public void create_shouldReturnCreatedRestaurant_whenTryToCreateANewRestaurant(){
        MenuItem jalebi = new MenuItem("dessert-01", "Jalebi", 30);
        CreateRestaurantRequest restaurantRequest = new CreateRestaurantRequest("dhaba", Collections.singletonList(jalebi));
        Restaurant expectedRestaurant = new Restaurant("dhaba", Collections.singletonList(jalebi));

        when(restaurantRepository.save(any(Restaurant.class))).thenReturn(expectedRestaurant);

        Restaurant restaurant = restaurantService.create(restaurantRequest);

        assertEquals(restaurant,expectedRestaurant);
    }
}
