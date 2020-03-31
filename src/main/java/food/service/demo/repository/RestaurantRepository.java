package food.service.demo.repository;

import food.service.demo.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    public Restaurant findRestaurantByName(String name);
}
