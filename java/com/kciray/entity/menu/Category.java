package com.kciray.entity.menu;

import com.kciray.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Component
public class Category implements BaseEntity <Integer>{
    private Integer id;
    private String name;
}
