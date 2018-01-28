package com.dongwt.glasses.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.CategoryRequest;
import com.dongwt.glasses.dao.Category;
import com.dongwt.glasses.mapper.CategoryMapper;
import com.dongwt.glasses.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dongwt on 2018/1/28.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public int add(Category category) {
        return categoryMapper.add(category);
    }

    @Override
    public int delete(Category category) {
        return categoryMapper.delete(category);
    }

    @Override
    public int update(Category category) {
        return categoryMapper.update(category);
    }

    @Override
    public CommonPagination<Category> queryForPage(CategoryRequest categoryRequest) {
        List<Category> brandList = categoryMapper.queryForPageData(categoryRequest);
        logger.info("brandList:{}", JSONObject.toJSONString(brandList));
        int count = categoryMapper.queryForPageCount(categoryRequest);
        logger.info("count:{}",count);
        CommonPagination<Category> commonPagination = new CommonPagination<>();
        commonPagination.setItems(brandList);
        commonPagination.setPage(categoryRequest);
        commonPagination.setTotal(count);
        return commonPagination;
    }
}
