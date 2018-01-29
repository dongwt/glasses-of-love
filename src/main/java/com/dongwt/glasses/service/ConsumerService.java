package com.dongwt.glasses.service;

import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.ConsumerRequest;
import com.dongwt.glasses.dao.Consumer;

/**
 * Created by dongwt on 2018/1/29.
 */
public interface ConsumerService {

    void add(Consumer consumer);


    void delete(Consumer consumer);


    void update(Consumer consumer);

    CommonPagination<Consumer> queryForPage(ConsumerRequest consumerRequest);
}
