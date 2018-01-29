package com.dongwt.glasses.service;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.BaseTest;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.BrandCategoryRequest;
import com.dongwt.glasses.api.request.BrandRequest;
import com.dongwt.glasses.dao.Brand;
import com.dongwt.glasses.dao.Category;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dongwt on 2018/1/28.
 */
public class BrandServiceImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BrandServiceImplTest.class);

    @Autowired
    private BrandService brandService;


    @Test
    public void add() {
        BrandRequest brandRequest = new BrandRequest();
        brandRequest.setName("艾伦");
        brandRequest.setCategoryIds(Arrays.asList(3l));
        brandService.add(brandRequest);
    }

    @Test
    public void delete() {
        BrandRequest brandRequest = new BrandRequest();
        brandRequest.setId(1l);
        brandService.delete(brandRequest);
    }

    @Test
    public void update() {
        BrandRequest brandRequest = new BrandRequest();
        brandRequest.setId(1l);
        brandRequest.setName("艾伦1");
        brandRequest.setCategoryIds(Arrays.asList(1l));
        brandService.update(brandRequest);
    }

    @Test
    public void queryForPage() {
        BrandRequest brandRequest = new BrandRequest();
        CommonPagination<Brand> data = brandService.queryForPage(brandRequest);
        logger.info("data:{}", JSONObject.toJSONString(data));
    }

    @Test
    public void queryCategory() {
        BrandCategoryRequest brandCategoryRequest = new BrandCategoryRequest();
        brandCategoryRequest.setBrandId(3l);
        List<Category> data = brandService.queryCategory(brandCategoryRequest);
        logger.info("data:{}", JSONObject.toJSONString(data));
    }
}
