package com.wordstalk.translate.demo.dao;

import com.wordstalk.translate.datasource.annotation.Mapper;
import com.wordstalk.translate.demo.dao.entity.Category;

/**
 */
@Mapper
public interface CategoryDao {

    public int countCategory();

    public Category queryCategoryById(Integer id);
}
