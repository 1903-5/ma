package com.qf.service.impl;

import com.qf.dao.AgriculturePictureDao;
import com.qf.domain.AgriculturePicture;
import com.qf.service.IPritureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PritureService implements IPritureService {
    @Autowired(required = false)
    private AgriculturePictureDao agriculturePictureDao;
    @Override
    public List<AgriculturePicture> loadByProductIdShowShop(Integer productId) {
        return agriculturePictureDao.loadByProductIdShowShop(productId);
    }



}
