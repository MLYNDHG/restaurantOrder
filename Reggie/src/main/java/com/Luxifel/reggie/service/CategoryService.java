package com.Luxifel.reggie.service;

import com.Luxifel.reggie.dao.CategoryDaoExp;
import com.Luxifel.reggie.mbg.dao.CategoryDao;
import com.Luxifel.reggie.mbg.model.Category;
import com.Luxifel.reggie.mbg.model.Employee;
import com.Luxifel.reggie.utils.QueryListRequest;
import com.Luxifel.reggie.utils.QueryListResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {
    @Resource
    private CategoryDao categoryDao;
    @Resource
    private CategoryDaoExp categoryDaoExp;

    public QueryListResult<Category> categoryList(QueryListRequest<Category> queryListRequest){
        try{
            Page page = PageHelper.startPage(queryListRequest.getPageCondition().getPageNo(), queryListRequest.getPageCondition().getPageSize());
            categoryDaoExp.categoryList();
            return new QueryListResult<>(page);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public List<Category> categoryTypeByList(int type){
        try{
            return categoryDaoExp.categoryTypeByList(type);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public int updateByPrimaryKeySelective(Category category){
        return categoryDao.updateByPrimaryKeySelective(category);
    }
    public Category selectByPrimaryKey(Long id){
        return categoryDao.selectByPrimaryKey(id);
    }

    public int insertSelective(Category category){
        return categoryDao.insertSelective(category);
    }

    public int deleteByPrimaryKey(Long id){
        return categoryDao.deleteByPrimaryKey(id);
    }
}
