package com.Luxifel.reggie.service;

import com.Luxifel.reggie.dao.CategoryDaoExp;
import com.Luxifel.reggie.dao.DishDaoExp;
import com.Luxifel.reggie.mbg.dao.CategoryDao;
import com.Luxifel.reggie.mbg.model.Category;
import com.Luxifel.reggie.mbg.model.Dish;
import com.Luxifel.reggie.mbg.model.Employee;
import com.Luxifel.reggie.model.DishExp;
import com.Luxifel.reggie.utils.QueryListRequest;
import com.Luxifel.reggie.utils.QueryListResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {
    @Resource
    private DishDaoExp dishDaoExp;
    @Autowired
    private CategoryService categoryService;

    public QueryListResult<DishExp> dishByNameList(QueryListRequest<Dish> queryListRequest){
        try{
            Page page = PageHelper.startPage(queryListRequest.getPageCondition().getPageNo(), queryListRequest.getPageCondition().getPageSize());
            List<Dish> DishList = dishDaoExp.dishByNameList(queryListRequest.getParamsCondition().getName());
            List<DishExp> dishExpList = new ArrayList<>();
            if(DishList !=null && DishList.size()>0){
                for (int i = 0; i < DishList.size(); i++) {
                    Dish dish = DishList.get(i);
                    DishExp dishExp = new DishExp();
                    BeanUtils.copyProperties(dish,dishExp);
                    //菜品名称
                    Category category = categoryService.selectByPrimaryKey(DishList.get(i).getCategoryId());
                    dishExp.setCategoryName(category.getName());
                    dishExpList.add(dishExp);
                }

            }
            QueryListResult<DishExp> queryListResult = new QueryListResult<>(page);
            queryListResult.setResultList(dishExpList);
            return queryListResult;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public List<Dish> checkNameExits(String name){
        try{
            return dishDaoExp.dishByNameList(name);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public DishExp dishByDishIdList(Long dishId){
        try{
            DishExp dishExp = new DishExp();
            Dish dish = dishDaoExp.selectByPrimaryKey(dishId);
            BeanUtils.copyProperties(dish,dishExp);
            return dishExp;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public QueryListResult<Dish> dishByCategoryIdList(Long categoryId){
        try{
            Page page = PageHelper.startPage(1, 10);
            dishDaoExp.dishByCategoryIdList(categoryId);
            return new QueryListResult<>(page);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    public int updateByPrimaryKeySelective(Dish dish){
        return dishDaoExp.updateByPrimaryKeySelective(dish);
    }

    public int insertSelective(Dish dish){
        return dishDaoExp.insertSelective(dish);
    }

    public int deleteByPrimaryKey(Long dishId){
        return dishDaoExp.deleteByPrimaryKey(dishId);
    }
}