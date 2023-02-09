package com.Luxifel.reggie.service;

import com.Luxifel.reggie.dao.SetmealDishDaoExp;
import com.Luxifel.reggie.mbg.model.Setmeal;
import com.Luxifel.reggie.mbg.model.SetmealDish;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SetmealDishService {
    @Resource
    private SetmealDishDaoExp setmealDishDaoExp;

    public List<SetmealDish> setmealDishBySetmealDishIdList(String setmealId){
        try{
            return setmealDishDaoExp.setmealDishBySetmealDishIdList(setmealId);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    public int insertSelective(SetmealDish setmealDish){
        return setmealDishDaoExp.insertSelective(setmealDish);
    }

    public int deleteByPrimaryKey(Long id){
        return setmealDishDaoExp.deleteByPrimaryKey(id);
    }

    public int deleteBySetmealDishId(String setmealId){
        return setmealDishDaoExp.deleteBySetmealDishId(setmealId);
    }
}
