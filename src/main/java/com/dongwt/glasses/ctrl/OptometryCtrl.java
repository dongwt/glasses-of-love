package com.dongwt.glasses.ctrl;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.OptometryRequest;
import com.dongwt.glasses.api.response.Response;
import com.dongwt.glasses.dao.Optometry;
import com.dongwt.glasses.service.OptometryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dongwt on 2018/1/29.
 */
@RestController
@RequestMapping("/optometry")
public class OptometryCtrl extends BaseCtrl{

    @Autowired
    private OptometryService optometryService;


    @RequestMapping("/add")
    public Response<String, Object> add(@RequestBody Optometry optometry) {
        logger.info("request:{}", JSONObject.toJSONString(optometry));
        try {
            optometryService.add(optometry);
        } catch (Exception e) {
            logger.error("add optometry error.", e);
            return Response.error();
        }
        return Response.success();
    }


    @RequestMapping("/delete")
    public Response<String, Object> delete(@RequestBody Optometry optometry) {
        logger.info("request:{}", JSONObject.toJSONString(optometry));
        try {
            optometryService.delete(optometry);
        } catch (Exception e) {
            logger.error("add optometry error.", e);
            return Response.error();
        }
        return Response.success();
    }


    @RequestMapping("/update")
    public Response<String, Object> update(@RequestBody Optometry optometry) {
        logger.info("request:{}", JSONObject.toJSONString(optometry));
        try {
            optometryService.update(optometry);
        } catch (Exception e) {
            logger.error("add optometry error.", e);
            return Response.error();
        }
        return Response.success();
    }

    @RequestMapping("/query")
    Response<List<Optometry>, Object> query(@RequestBody Optometry optometry) {
        logger.info("request:{}", JSONObject.toJSONString(optometry));
        try {
            List<Optometry> data = optometryService.query(optometry);
            Response<List<Optometry>, Object> response = Response.success();
            response.setData(data);
            return response;
        } catch (Exception e) {
            logger.error("query error.", e);
            return Response.error();
        }
    }

    @RequestMapping("/queryForPage")
    Response<CommonPagination<Optometry>, Object> queryForPage(@RequestBody OptometryRequest optometryRequest) {
        logger.info("request:{}", JSONObject.toJSONString(optometryRequest));
        try {
            CommonPagination<Optometry> data = optometryService.queryForPage(optometryRequest);
            Response<CommonPagination<Optometry>, Object> response = Response.success();
            response.setData(data);
            return response;
        } catch (Exception e) {
            logger.error("queryForPage error.", e);
            return Response.error();
        }
    }
}
