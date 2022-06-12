package com.mingyang.reggie.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class SetmealDishesDTO {
    @JsonProperty("copies")
    private Integer copies;
    @JsonProperty("dishId")
    private String dishId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private BigDecimal price;
}