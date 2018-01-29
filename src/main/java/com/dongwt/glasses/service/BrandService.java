package com.dongwt.glasses.service;

import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.BrandCategoryRequest;
import com.dongwt.glasses.api.request.BrandRequest;
import com.dongwt.glasses.dao.Brand;
import com.dongwt.glasses.dao.Category;

import java.util.List;

/**
 * 品牌服务
 */
public interface BrandService {

    void add(BrandRequest brandRequest);


    void delete(BrandRequest brandRequest);


    void update(BrandRequest brandRequest);

    CommonPagination<Brand> queryForPage(BrandRequest brandRequest);


    List<Category> queryCategory(BrandCategoryRequest brandCategoryRequest);
}
