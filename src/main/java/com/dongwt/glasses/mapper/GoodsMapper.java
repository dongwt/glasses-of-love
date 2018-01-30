package com.dongwt.glasses.mapper;

import com.dongwt.glasses.api.request.GoodsRequest;
import com.dongwt.glasses.dao.Goods;

import java.util.List;

/**
 * Created by dongwt on 2018/1/30.
 */
public interface GoodsMapper {

    int insert(Goods goods);

    int add(Goods goods);

    int reduce(Goods goods);

    int delete(Goods goods);

    int update(Goods goods);

    Goods queryById(Goods goods);

    Goods query(Goods goods);

    List<Goods> queryForPageData(GoodsRequest goodsRequest);

    int queryForPageCount(GoodsRequest goodsRequest);
}
