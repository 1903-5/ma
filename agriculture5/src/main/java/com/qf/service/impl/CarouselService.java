package com.qf.service.impl;

import com.qf.dao.CarouselRepository;
import com.qf.domain.Carousel;
import com.qf.service.ICarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselService implements ICarouselService {
    @Autowired
    private CarouselRepository carouselRepository;
    @Override
    public List<Carousel> findAll() {
        return carouselRepository.findAll();
    }
}
