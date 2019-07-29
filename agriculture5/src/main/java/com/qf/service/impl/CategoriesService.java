package com.qf.service.impl;

import com.qf.dao.CategoriesRepository;
import com.qf.domain.Categories;
import com.qf.service.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService implements ICategoriesService {
    @Autowired
    private CategoriesRepository cateforiesRepository;
    @Override
    public List<Categories> findAll() {
        return cateforiesRepository.findAll();
    }
}
