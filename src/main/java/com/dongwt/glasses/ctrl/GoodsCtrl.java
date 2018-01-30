package com.dongwt.glasses.ctrl;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.BrandRequest;
import com.dongwt.glasses.api.request.GoodsRequest;
import com.dongwt.glasses.api.response.Response;
import com.dongwt.glasses.dao.Goods;
import com.dongwt.glasses.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品
 */
@RestController
@RequestMapping("/goods")
public class GoodsCtrl extends BaseCtrl {

    @Autowired
    private GoodsService goodsService;


    @RequestMapping("/add")
    public Response<String, Object> add(@RequestBody Goods goods) {
        logger.info("request:{}", JSONObject.toJSONString(goods));
        try {
            goodsService.add(goods);
        } catch (Exception e) {
            logger.error("add goods error.", e);
            return Response.error();
        }
        return Response.success();
    }

    @RequestMapping("/reduce")
    public Response<String, Object> reduce(@RequestBody Goods goods) {
        logger.info("request:{}", JSONObject.toJSONString(goods));
        try {
            goodsService.reduce(goods);
        } catch (Exception e) {
            logger.error("reduce goods error.", e);
            return Response.error();
        }
        return Response.success();
    }


    @RequestMapping("/delete")
    public Response<String, Object> delete(@RequestBody Goods goods) {
        logger.info("request:{}", JSONObject.toJSONString(goods));
        try {
            goodsService.delete(goods);
        } catch (Exception e) {
            logger.error("add goods error.", e);
            return Response.error();
        }
        return Response.success();
    }


    @RequestMapping("/update")
    public Response<String, Object> update(@RequestBody Goods goods) {
        logger.info("request:{}", JSONObject.toJSONString(goods));
        try {
            goodsService.update(goods);
        } catch (Exception e) {
            logger.error("update goods error.", e);
            return Response.error();
        }
        return Response.success();
    }

    @RequestMapping("/queryForPage")
    Response<CommonPagination<Goods>, Object> queryForPage(@RequestBody GoodsRequest goodsRequest) {
        logger.info("request:{}", JSONObject.toJSONString(goodsRequest));
        try {
            CommonPagination<Goods> data = goodsService.queryForPage(goodsRequest);
            Response<CommonPagination<Goods>, Object> response = Response.success();
            response.setData(data);
            return response;
        } catch (Exception e) {
            logger.error("queryForPage error.", e);
            return Response.error();
        }
    }
}
