package com.qf.service;

import com.qf.domain.Subclass;

import java.util.List;

public interface ISubclassService {
    public List<Subclass> findByCategoriesId(Integer categoriesId);
}
