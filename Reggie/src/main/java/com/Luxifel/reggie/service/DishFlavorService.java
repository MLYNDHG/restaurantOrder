package com.Luxifel.reggie.service;

import com.Luxifel.reggie.dao.DishFlavorDaoExp;
import com.Luxifel.reggie.mbg.model.Dish;
import com.Luxifel.reggie.mbg.model.DishFlavor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DishFlavorService {
    @Resource
    private DishFlavorDaoExp dishFlavorDaoExp;

    public List<DishFlavor> dishFlavorByDishIdList(Long DishId){
        try{
            return dishFlavorDaoExp.dishFlavorByDishIdList(DishId);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    public int insertSelective(DishFlavor dishFlavor){
        return dishFlavorDaoExp.insertSelective(dishFlavor);
    }

    public int deleteByPrimaryKey(Long id){
        return dishFlavorDaoExp.deleteByPrimaryKey(id);
    }

    public int deleteByDishId(Long id){
        return dishFlavorDaoExp.deleteByDishId(id);
    }
}
