package com.Luxifel.reggie.model;

import com.Luxifel.reggie.mbg.model.Dish;
import com.Luxifel.reggie.mbg.model.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DishExp extends Dish {
    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
