package com.Luxifel.reggie.model;

import com.Luxifel.reggie.mbg.model.Setmeal;
import com.Luxifel.reggie.mbg.model.SetmealDish;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SetmealExp extends Setmeal {
    private List<SetmealDish> setmealDishes = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
