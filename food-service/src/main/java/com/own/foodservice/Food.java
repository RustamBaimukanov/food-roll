package com.own.foodservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table("food")
public class Food{

    @Id
    private Long id;
    private String name;
    private Difficulty difficulty;
    private byte[] image;
    private String imageFileExtension;

}
