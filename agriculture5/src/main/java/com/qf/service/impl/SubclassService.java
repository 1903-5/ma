package com.qf.service.impl;

import com.qf.dao.SubclassDao;
import com.qf.domain.Subclass;
import com.qf.service.ISubclassService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubclassService implements ISubclassService {
    @Autowired(required = false)
    private SubclassDao subclassDao;

    @Override
    public List<Subclass> findByCategoriesId(Integer categoriesId) {
        return subclassDao.findByCategoriesId(categoriesId);
    }
}
