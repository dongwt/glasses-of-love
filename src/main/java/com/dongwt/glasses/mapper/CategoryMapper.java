package com.dongwt.glasses.mapper;

import com.dongwt.glasses.api.request.CategoryRequest;
import com.dongwt.glasses.dao.Category;

import java.util.List;

/**
 * Created by dongwt on 2018/1/28.
 */
public interface CategoryMapper {

    int add(Category category);


    int delete(Category category);


    int update(Category category);

    List<Category> queryForPageData(CategoryRequest categoryRequest);

    int queryForPageCount(CategoryRequest categoryRequest);
}
