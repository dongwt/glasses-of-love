package com.dongwt.glasses.ctrl;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.BrandRequest;
import com.dongwt.glasses.api.response.Response;
import com.dongwt.glasses.dao.Brand;
import com.dongwt.glasses.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 品牌
 */
@RestController
@RequestMapping("/brands")
public class BrandCtrl extends BaseCtrl {

    @Autowired
    private BrandService brandService;


    @RequestMapping("/add")
    public Response<String, Object> add(@RequestBody BrandRequest brandRequest) {
        logger.info("request:{}", JSONObject.toJSONString(brandRequest));
        try {
            brandService.add(brandRequest);
        } catch (Exception e) {
            logger.error("add brand error.", e);
            return Response.error();
        }
        return Response.success();
    }


    @RequestMapping("/delete")
    public Response<String, Object> delete(@RequestBody BrandRequest brandRequest) {
        logger.info("request:{}", JSONObject.toJSONString(brandRequest));
        try {
            brandService.delete(brandRequest);
        } catch (Exception e) {
            logger.error("delete brand error.", e);
            return Response.error();
        }
        return Response.success();
    }


    @RequestMapping("/update")
    public Response<String, Object> update(@RequestBody BrandRequest brandRequest) {
        logger.info("request:{}", JSONObject.toJSONString(brandRequest));
        try {
            brandService.update(brandRequest);
        } catch (Exception e) {
            logger.error("update brand error.", e);
            return Response.error();
        }
        return Response.success();
    }

    @RequestMapping("/queryForPage")
    Response<CommonPagination<Brand>, Object> queryForPage(@RequestBody BrandRequest brandRequest) {
        logger.info("request:{}", JSONObject.toJSONString(brandRequest));
        try {
            CommonPagination<Brand> data = brandService.queryForPage(brandRequest);
            Response<CommonPagination<Brand>, Object> response = Response.success();
            response.setData(data);
            return response;
        } catch (Exception e) {
            logger.error("queryForPage error.", e);
            return Response.error();
        }
    }

}
