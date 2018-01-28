package com.dongwt.glasses.mapper;

import com.dongwt.glasses.api.request.BrandRequest;
import com.dongwt.glasses.dao.Brand;

import java.util.List;

/**
 * Created by dongwt on 2018/1/28.
 */
public interface BrandMapper {

    int add(Brand brand);


    int delete(Brand brand);


    int update(Brand brand);

    List<Brand>  queryForPageData(BrandRequest brandRequest);

    int queryForPageCount(BrandRequest brandRequest);
}
