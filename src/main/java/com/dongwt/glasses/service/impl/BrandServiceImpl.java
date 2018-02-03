package com.dongwt.glasses.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.BrandCategoryRequest;
import com.dongwt.glasses.api.request.BrandRequest;
import com.dongwt.glasses.dao.Brand;
import com.dongwt.glasses.dao.BrandCategory;
import com.dongwt.glasses.dao.Category;
import com.dongwt.glasses.mapper.BrandCategoryMapper;
import com.dongwt.glasses.mapper.BrandMapper;
import com.dongwt.glasses.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dongwt on 2018/1/28.
 */
@Service
public class BrandServiceImpl implements BrandService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private BrandCategoryMapper brandCategoryMapper;


    private synchronized void  addBrandCategory(BrandRequest brandRequest){
        if (null != brandRequest.getCategoryIds()) {
            for (Long categoryId : brandRequest.getCategoryIds()) {
                BrandCategory brandCategory = new BrandCategory();
                brandCategory.setBrandId(brandRequest.getId());
                brandCategory.setCategoryId(categoryId);
                brandCategoryMapper.add(brandCategory);
            }
        }
    }

    @Transactional
    @Override
    public synchronized void add(BrandRequest brandRequest) {
        //1.添加品牌
        Brand brand = new Brand();
        brand.setName(brandRequest.getName());
        brandMapper.add(brand);
        //2.添加品牌类别关联数据
        brandRequest.setId(brand.getId());
        addBrandCategory(brandRequest);
    }

    @Transactional
    @Override
    public synchronized void delete(BrandRequest brandRequest) {
        //1.删除品牌
        Brand brand = new Brand();
        brand.setId(brandRequest.getId());
        brandMapper.delete(brand);
        //2.删除品牌类别关联数据
        brandCategoryMapper.batchDeleteForBrandId(brandRequest.getId());
    }

    @Transactional
    @Override
    public synchronized void update(BrandRequest brandRequest) {
        //1.更新品牌
        Brand brand = new Brand();
        brand.setId(brandRequest.getId());
        brand.setName(brandRequest.getName());
        brandMapper.update(brand);
        //2.删除品牌类别关联数据
        brandCategoryMapper.batchDeleteForBrandId(brandRequest.getId());
        //3.添加品牌类别关联数据
        addBrandCategory(brandRequest);
    }

    @Override
    public CommonPagination<Brand> queryForPage(BrandRequest brandRequest) {
        List<Brand> brandList = brandMapper.queryForPageData(brandRequest);
        logger.info("brandList:{}", JSONObject.toJSONString(brandList));
        int count = brandMapper.queryForPageCount(brandRequest);
        logger.info("count:{}", count);
        CommonPagination<Brand> commonPagination = new CommonPagination<>();
        commonPagination.setItems(brandList);
        commonPagination.setPage(brandRequest);
        commonPagination.setTotal(count);
        return commonPagination;
    }


    @Override
    public List<Category> queryCategory(BrandCategoryRequest brandCategoryRequest) {
        List<Category> categoryList = brandCategoryMapper.query(brandCategoryRequest.getBrandId());
        logger.info("categoryList:{}", JSONObject.toJSONString(categoryList));
        return categoryList;
    }
}
