package food.service.demo.web_api_contract;

import food.service.demo.entity.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class CreateRestaurantRequest {
    private String name;
    private List<MenuItem> menu;
}
