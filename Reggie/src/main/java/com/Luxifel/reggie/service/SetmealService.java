package com.Luxifel.reggie.service;

import com.Luxifel.reggie.dao.SetmealDaoExp;
import com.Luxifel.reggie.mbg.model.Category;
import com.Luxifel.reggie.mbg.model.Dish;
import com.Luxifel.reggie.mbg.model.Setmeal;
import com.Luxifel.reggie.model.DishExp;
import com.Luxifel.reggie.model.SetmealExp;
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
public class SetmealService {
    @Resource
    private SetmealDaoExp setmealDaoExp;
    @Autowired
    private CategoryService categoryService;

    public QueryListResult<SetmealExp> setmealByNameList(QueryListRequest<Setmeal> queryListRequest){
        try{
            Page page = PageHelper.startPage(queryListRequest.getPageCondition().getPageNo(), queryListRequest.getPageCondition().getPageSize());
            List<Setmeal> SetmealList = setmealDaoExp.setmealByNameList(queryListRequest.getParamsCondition().getName());
            List<SetmealExp> SetmealExpList = new ArrayList<>();
            if(SetmealList !=null && SetmealList.size()>0){
                for (int i = 0; i < SetmealList.size(); i++) {
                    Setmeal setmeal = SetmealList.get(i);
                    SetmealExp setmealExp = new SetmealExp();
                    BeanUtils.copyProperties(setmeal,setmealExp);
                    //菜品名称
                    Category category = categoryService.selectByPrimaryKey(SetmealList.get(i).getCategoryId());
                    setmealExp.setCategoryName(category.getName());
                    SetmealExpList.add(setmealExp);
                }

            }
            QueryListResult<SetmealExp> queryListResult = new QueryListResult<>(page);
            queryListResult.setResultList(SetmealExpList);
            return queryListResult;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public SetmealExp setmealBySetmealIdList(Long setmealId){
        try{
            SetmealExp setmealExp = new SetmealExp();
            Setmeal setmeal = setmealDaoExp.selectByPrimaryKey(setmealId);
            BeanUtils.copyProperties(setmeal,setmealExp);
            return setmealExp;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public QueryListResult<Setmeal> setmealByCategoryIdList(Long categoryId){
        try{
            Page page = PageHelper.startPage(1, 10);
            setmealDaoExp.setmealByCategoryIdList(categoryId);
            return new QueryListResult<>(page);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public List<Setmeal> checkNameExits(String name){
        try{
            return setmealDaoExp.setmealByNameList(name);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    public int updateByPrimaryKeySelective(Setmeal setmeal){
        return setmealDaoExp.updateByPrimaryKeySelective(setmeal);
    }

    public int insertSelective(Setmeal setmeal){
        return setmealDaoExp.insertSelective(setmeal);
    }

    public int deleteByPrimaryKey(Long id){
        return setmealDaoExp.deleteByPrimaryKey(id);
    }
}
