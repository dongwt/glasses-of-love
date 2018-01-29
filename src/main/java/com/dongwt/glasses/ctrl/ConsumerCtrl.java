package com.dongwt.glasses.ctrl;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.ConsumerRequest;
import com.dongwt.glasses.api.response.Response;
import com.dongwt.glasses.dao.Consumer;
import com.dongwt.glasses.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dongwt on 2018/1/29.
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerCtrl extends BaseCtrl {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/add")
    public Response<String, Object> add(@RequestBody Consumer consumer) {
        logger.info("request:{}", JSONObject.toJSONString(consumer));
        try {
            consumerService.add(consumer);
        } catch (Exception e) {
            logger.error("add consumer error.", e);
            return Response.error();
        }
        return Response.success();
    }


    @RequestMapping("/delete")
    public Response<String, Object> delete(@RequestBody Consumer consumer) {
        logger.info("request:{}", JSONObject.toJSONString(consumer));
        try {
            consumerService.delete(consumer);
        } catch (Exception e) {
            logger.error("add consumer error.", e);
            return Response.error();
        }
        return Response.success();
    }


    @RequestMapping("/update")
    public Response<String, Object> update(@RequestBody Consumer consumer) {
        logger.info("request:{}", JSONObject.toJSONString(consumer));
        try {
            consumerService.update(consumer);
        } catch (Exception e) {
            logger.error("add consumer error.", e);
            return Response.error();
        }
        return Response.success();
    }

    @RequestMapping("/queryForPage")
    Response<CommonPagination<Consumer>, Object> queryForPage(@RequestBody ConsumerRequest consumerRequest) {
        logger.info("request:{}", JSONObject.toJSONString(consumerRequest));
        try {
            CommonPagination<Consumer> data = consumerService.queryForPage(consumerRequest);
            Response<CommonPagination<Consumer>, Object> response = Response.success();
            response.setData(data);
            return response;
        } catch (Exception e) {
            logger.error("queryForPage error.", e);
            return Response.error();
        }
    }


}
