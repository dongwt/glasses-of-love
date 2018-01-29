package com.dongwt.glasses.mapper;

import com.dongwt.glasses.api.request.ConsumerRequest;
import com.dongwt.glasses.dao.Consumer;

import java.util.List;

/**
 * Created by dongwt on 2018/1/29.
 */
public interface ConsumerMapper {

    int add(Consumer consumer);

    int delete(Consumer consumer);

    int update(Consumer consumer);

    List<Consumer> queryForPageData(ConsumerRequest consumerRequest);

    int queryForPageCount(ConsumerRequest consumerRequest);
}
