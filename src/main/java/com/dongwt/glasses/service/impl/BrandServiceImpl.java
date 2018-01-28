package com.dongwt.glasses.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.BrandRequest;
import com.dongwt.glasses.api.response.Response;
import com.dongwt.glasses.dao.Brand;
import com.dongwt.glasses.mapper.BrandMapper;
import com.dongwt.glasses.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dongwt on 2018/1/28.
 */
@Service
public class BrandServiceImpl implements BrandService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public int add(Brand brand) {
        return brandMapper.add(brand);
    }

    @Override
    public int delete(Brand brand) {
        return brandMapper.delete(brand);
    }

    @Override
    public int update(Brand brand) {
        return brandMapper.update(brand);
    }

    @Override
    public CommonPagination<Brand> queryForPage(BrandRequest brandRequest) {
        List<Brand> brandList = brandMapper.queryForPageData(brandRequest);
        logger.info("brandList:{}", JSONObject.toJSONString(brandList));
        int count = brandMapper.queryForPageCount(brandRequest);
        logger.info("count:{}",count);
        CommonPagination<Brand> commonPagination = new CommonPagination<>();
        commonPagination.setItems(brandList);
        commonPagination.setPage(brandRequest);
        commonPagination.setTotal(count);
        return commonPagination;
    }
}
