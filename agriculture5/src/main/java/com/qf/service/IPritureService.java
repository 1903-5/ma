package com.qf.service;

import com.qf.domain.AgriculturePicture;

import java.util.List;

public interface IPritureService {
    List<AgriculturePicture> loadByProductIdShowShop(Integer productId);

}
