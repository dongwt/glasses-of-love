package com.dongwt.glasses.service;

import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.CategoryRequest;
import com.dongwt.glasses.dao.Category;

/**
 * Created by dongwt on 2018/1/28.
 */
public interface CategoryService {

    int add(Category category);


    int delete(Category category);


    int update(Category category);

    CommonPagination<Category> queryForPage(CategoryRequest categoryRequest);
}
