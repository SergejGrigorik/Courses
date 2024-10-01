package com.kciray.model.menu;

import com.kciray.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Component
@ToString
@Entity
@Table(name = "Pfcc")
public class Pfcc implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double proteins;
    private Double fats;
    private Double calories;
    private Double carbohydrates;

    @Builder.Default
    @OneToMany(mappedBy = "pfcc", fetch = FetchType.LAZY)
    private List <Dish> dish = new ArrayList<>();


}
