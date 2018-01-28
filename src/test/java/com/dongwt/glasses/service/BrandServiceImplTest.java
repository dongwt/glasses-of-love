package com.dongwt.glasses.service;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.BaseTest;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.BrandRequest;
import com.dongwt.glasses.dao.Brand;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dongwt on 2018/1/28.
 */
public class BrandServiceImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BrandServiceImplTest.class);

    @Autowired
    private BrandService brandService;


    @Test
    public void add() {
        Brand brand = new Brand();
        brand.setName("艾伦");
        brandService.add(brand);
    }

    @Test
    public void delete() {
        Brand brand = new Brand();
        brand.setId(1l);
        brandService.delete(brand);
    }

    @Test
    public void update() {
        Brand brand = new Brand();
        brand.setId(1l);
        brand.setName("艾伦1");
        brandService.update(brand);
    }

    @Test
    public void queryForPage() {
        BrandRequest brandRequest  = new BrandRequest();
        CommonPagination<Brand> data = brandService.queryForPage(brandRequest);
        logger.info("data:{}", JSONObject.toJSONString(data));
    }
}
