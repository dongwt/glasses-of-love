package com.dongwt.glasses.service;

import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.GoodsRequest;
import com.dongwt.glasses.dao.Goods;

/**
 * Created by dongwt on 2018/1/30.
 */
public interface GoodsService {

    void insert(Goods goods);

    void add(Goods goods);

    void reduce(Goods goods);

    void delete(Goods goods);

    void update(Goods goods);

    CommonPagination<Goods> queryForPage(GoodsRequest goodsRequest);
}
