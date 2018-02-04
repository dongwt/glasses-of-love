package com.dongwt.glasses.service;

import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.OptometryRequest;
import com.dongwt.glasses.dao.Optometry;

import java.util.List;

/**
 * Created by dongwt on 2018/1/29.
 */
public interface OptometryService {

    void add(Optometry optometry);

    void delete(Optometry optometry);

    void update(Optometry optometry);

    List<Optometry> query(Optometry optometry);

    CommonPagination<Optometry> queryForPage(OptometryRequest optometryRequest);
}
