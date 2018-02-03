package com.dongwt.glasses.service.impl;

import com.dongwt.glasses.dao.Optometry;
import com.dongwt.glasses.mapper.OptometryMapper;
import com.dongwt.glasses.service.OptometryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dongwt on 2018/1/29.
 */
@Service
public class OptometryServiceImpl implements OptometryService {

    @Autowired
    private OptometryMapper optometryMapper;

    @Override
    public synchronized void add(Optometry optometry) {
        optometryMapper.add(optometry);
    }

    @Override
    public synchronized void delete(Optometry optometry) {
        optometryMapper.delete(optometry);
    }

    @Override
    public synchronized void update(Optometry optometry) {
        optometryMapper.update(optometry);
    }

    @Override
    public List<Optometry> query(Optometry optometry) {
        return optometryMapper.query(optometry);
    }
}
