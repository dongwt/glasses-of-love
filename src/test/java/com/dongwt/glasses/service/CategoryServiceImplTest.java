package com.dongwt.glasses.service;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.BaseTest;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.BrandRequest;
import com.dongwt.glasses.api.request.CategoryRequest;
import com.dongwt.glasses.dao.Brand;
import com.dongwt.glasses.dao.Category;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dongwt on 2018/1/28.
 */
public class CategoryServiceImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImplTest.class);

    @Autowired
    private CategoryService categoryService;


    @Test
    public void add() {
        Category category = new Category();
        category.setName("散光-50");
        categoryService.add(category);
    }

    @Test
    public void delete() {
        Category category = new Category();
        category.setId(3l);
        categoryService.delete(category);
    }

    @Test
    public void update() {
        Category category = new Category();
        category.setId(1l);
        category.setName("散光-70");
        categoryService.update(category);
    }

    @Test
    public void queryForPage() {
        CategoryRequest categoryRequest  = new CategoryRequest();
        CommonPagination<Category> data = categoryService.queryForPage(categoryRequest);
        logger.info("data:{}", JSONObject.toJSONString(data));
    }
}
