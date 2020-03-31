package food.service.demo.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @EqualsAndHashCode @ToString
public class MenuItem {
    private String id;
    private String name;
    private int price;
}
