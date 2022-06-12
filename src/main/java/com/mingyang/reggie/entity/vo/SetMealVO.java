package com.mingyang.reggie.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mingyang.reggie.entity.Setmeal;
import com.mingyang.reggie.entity.dto.SetmealDishesDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/12 20:24
 * @version: 1.0
 */
@NoArgsConstructor
@Data
public class SetMealVO {
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("categoryId")
    private Long categoryId;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("code")
    private String code;
    @JsonProperty("image")
    private String image;
    @JsonProperty("description")
    private String description;
    @JsonProperty("dishList")
    private List<?> dishList;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("idType")
    private String idType;
    @JsonProperty("setmealDishes")
    private List<SetmealDishesDTO> setmealDishes;

    public static Setmeal convertToSetmeal(SetMealVO item) {
        if (item == null) {
            return null;
        }
        Setmeal result = new Setmeal();
        if(item.getId() != null) {
            result.setId(item.getId());
        }
        result.setCategoryId(item.getCategoryId());
        result.setName(item.getName());
        result.setPrice(item.getPrice());
        result.setStatus(item.getStatus());
        result.setCode(item.getCode());
        result.setDescription(item.getDescription());
        result.setImage(item.getImage());
        return result;
    }

    public static SetMealVO convertToSetMealVO(Setmeal item) {
        if (item == null) {
            return null;
        }
        SetMealVO result = new SetMealVO();
        result.setId(item.getId());
        result.setName(item.getName());
        result.setCategoryId(item.getCategoryId());
        result.setPrice(item.getPrice());
        result.setCode(item.getCode());
        result.setImage(item.getImage());
        result.setDescription(item.getDescription());
        result.setStatus(item.getStatus());
        return result;
    }
}
