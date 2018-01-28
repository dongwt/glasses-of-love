package com.dongwt.glasses.service;

import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.BrandRequest;
import com.dongwt.glasses.dao.Brand;

/**
 * 品牌服务
 */
public interface BrandService {

    int add(Brand brand);


    int delete(Brand brand);


    int update(Brand brand);

    CommonPagination<Brand> queryForPage(BrandRequest brandRequest);
}
