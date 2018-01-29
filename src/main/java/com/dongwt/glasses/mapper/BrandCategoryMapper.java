package com.dongwt.glasses.mapper;

import com.dongwt.glasses.dao.BrandCategory;
import com.dongwt.glasses.dao.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dongwt on 2018/1/29.
 */
public interface BrandCategoryMapper {

    int add(BrandCategory brandCategory);


    int delete(BrandCategory brandCategory);

    int batchDeleteForBrandId(@Param("brandId") Long brandId);

    List<Category> query(@Param("brandId") Long brandId);
}
