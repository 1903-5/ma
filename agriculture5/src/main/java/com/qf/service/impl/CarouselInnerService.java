package com.qf.service.impl;

import com.qf.dao.CarouselInnerRepository;
import com.qf.domain.CarouselInner;
import com.qf.service.ICarouselInnerServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselInnerService implements ICarouselInnerServise {
    @Autowired
    private CarouselInnerRepository carousleInnerRepository;
    @Override
    public List<CarouselInner> findAll() {
        return carousleInnerRepository.findAll();
    }
}
