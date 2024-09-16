package com.kciray.model.menu;

import com.kciray.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "dishes")
@Data
@Builder
@Component
@Entity
public class Category implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "category" ,cascade = CascadeType.ALL)
    private List<Dish> dishes = new ArrayList<>();

    public void addDish(Dish dish){
        dishes.add(dish);
        dish.setCategory(this);
    }
}
