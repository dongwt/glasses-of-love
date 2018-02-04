package com.dongwt.glasses.mapper;

import com.dongwt.glasses.api.request.OptometryRequest;
import com.dongwt.glasses.dao.Optometry;

import java.util.List;

/**
 * Created by dongwt on 2018/1/29.
 */
public interface OptometryMapper {

    int add(Optometry optometry);

    int delete(Optometry optometry);

    int update(Optometry optometry);

    List<Optometry> query(Optometry optometry);

    List<Optometry> queryForPageData(OptometryRequest optometryRequest);

    int queryForPageCount(OptometryRequest optometryRequest);
}
