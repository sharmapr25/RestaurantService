package food.service.demo.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.service.demo.entity.MenuItem;
import food.service.demo.web_api_contract.CreateRestaurantRequest;
import food.service.demo.web_api_contract.CreateRestaurantResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestaurantControllerTest {

    @LocalServerPort
    private int randomServerPort;

    @Autowired
    RestaurantController consumerController;

    @Autowired
    TestRestTemplate restTemplate;

    ObjectMapper objectMapper;

    @Before
    public void setup(){
        objectMapper = new ObjectMapper();
    }

    @Test
    public void createOrder_shouldReturnOrderIdWithOrderStatePendingApproval_whenOrderCreatedForFirstTime() throws JsonProcessingException {
        String baseUrl = "http://localhost:" + randomServerPort + "/restaurants";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        MenuItem jalebi = new MenuItem("dessert-01", "Jalebi", 30);
        CreateRestaurantRequest restaurantRequest = new CreateRestaurantRequest("dhaba", Collections.singletonList(jalebi));
        ;
        String firstRestaurant = objectMapper.writeValueAsString(restaurantRequest);

        HttpEntity<String> request = new HttpEntity<>(firstRestaurant, httpHeaders);
        String response = this.restTemplate.postForObject(baseUrl, request, String.class);
        CreateRestaurantResponse orderResponse = objectMapper.readValue(response, CreateRestaurantResponse.class);

        assertNotNull(orderResponse.getId());

    }
}
