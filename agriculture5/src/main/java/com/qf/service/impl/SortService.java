package com.qf.service.impl;

import com.qf.dao.SortRepository;
import com.qf.domain.Sort;
import com.qf.service.ISortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortService implements ISortService {
    @Autowired
    private SortRepository sortRepository;
    @Override
    public List<Sort> findAll() {
        return sortRepository.findAll();
    }
}
