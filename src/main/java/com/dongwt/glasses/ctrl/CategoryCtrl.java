package com.dongwt.glasses.ctrl;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.BrandRequest;
import com.dongwt.glasses.api.request.CategoryRequest;
import com.dongwt.glasses.api.response.Response;
import com.dongwt.glasses.dao.Brand;
import com.dongwt.glasses.dao.Category;
import com.dongwt.glasses.service.BrandService;
import com.dongwt.glasses.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dongwt on 2018/1/28.
 */
@RestController
@RequestMapping("/category")
public class CategoryCtrl extends BaseCtrl{

    @Autowired
    private CategoryService categoryService;


    @RequestMapping("/add")
    public Response<String, Object> add(@RequestBody Category category) {
        logger.info("request:{}", JSONObject.toJSONString(category));
        try {
            categoryService.add(category);
        } catch (Exception e) {
            logger.error("add category error.", e);
            return Response.error();
        }
        return Response.success();
    }


    @RequestMapping("/delete")
    public Response<String, Object> delete(@RequestBody Category category) {
        logger.info("request:{}", JSONObject.toJSONString(category));
        try {
            categoryService.delete(category);
        } catch (Exception e) {
            logger.error("add category error.", e);
            return Response.error();
        }
        return Response.success();
    }


    @RequestMapping("/update")
    public Response<String, Object> update(@RequestBody Category category) {
        logger.info("request:{}", JSONObject.toJSONString(category));
        try {
            categoryService.update(category);
        } catch (Exception e) {
            logger.error("add category error.", e);
            return Response.error();
        }
        return Response.success();
    }

    @RequestMapping("/queryForPage")
    Response<CommonPagination<Category>, Object> queryForPage(@RequestBody CategoryRequest categoryRequest) {
        logger.info("request:{}", JSONObject.toJSONString(categoryRequest));
        try {
            CommonPagination<Category> data = categoryService.queryForPage(categoryRequest);
            Response<CommonPagination<Category>, Object> response = Response.success();
            response.setData(data);
            return response;
        } catch (Exception e) {
            logger.error("queryForPage error.", e);
            return Response.error();
        }
    }
}
