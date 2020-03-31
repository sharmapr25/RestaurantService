package food.service.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "restaurant_menu")
    private List<MenuItem> menuItems;

    public Restaurant(String name, List<MenuItem> menuItems) {
        this.name = name;
        this.menuItems = menuItems;
    }
}
