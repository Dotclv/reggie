package com.mingyang.reggie.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mingyang.reggie.entity.Dish;
import com.mingyang.reggie.entity.DishFlavor;
import com.mingyang.reggie.entity.dto.FlavorsDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/12 15:45
 * @version: 1.0
 */
@NoArgsConstructor
@Data
public class DishVO {
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("code")
    private String code;
    @JsonProperty("image")
    private String image;
    @JsonProperty("description")
    private String description;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("categoryId")
    private Long categoryId;
    @JsonProperty("flavors")
    private List<FlavorsDTO> flavors;

    public static Dish convertToDishVO(DishVO item) {
        if (item == null) {
            return null;
        }
        Dish result = new Dish();
        if(item.getId() != null) {
            result.setId(item.getId());
        }
        result.setName(item.getName());
        result.setPrice(item.getPrice());
        result.setCode(item.getCode());
        result.setImage(item.getImage());
        result.setDescription(item.getDescription());
        result.setStatus(item.getStatus());
        result.setCategoryId(item.getCategoryId());
        return result;
    }

    public static DishVO convertToDishVO(Dish item) {
        if (item == null) {
            return null;
        }
        DishVO result = new DishVO();
        if(item.getId() != null) {
            result.setId(item.getId());
        }
        result.setName(item.getName());
        result.setPrice(item.getPrice());
        result.setCode(item.getCode());
        result.setImage(item.getImage());
        result.setDescription(item.getDescription());
        result.setStatus(item.getStatus());
        result.setCategoryId(item.getCategoryId());
        return result;
    }
}
