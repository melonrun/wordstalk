package com.wordstalk.translate.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wordstalk.translate.demo.dao.CategoryDao;
import com.wordstalk.translate.demo.service.ICategoryService;
import com.wordstalk.translate.demo.service.model.CategoryRelation;


/**
 */
@Service("categoryService")
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional("crmTXManager")
    public CategoryRelation packageCategoryRelation(Integer id) {
        return new CategoryRelation(categoryDao.queryCategoryById(id), categoryDao.countCategory());
    }

}
