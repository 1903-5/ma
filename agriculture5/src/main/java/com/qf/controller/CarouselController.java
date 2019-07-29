package com.qf.controller;

import com.qf.domain.Carousel;
import com.qf.service.ICarouselService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/carousel")
@ResponseBody
public class CarouselController {
    @Autowired
    private ICarouselService carouselService;
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ApiOperation("查询全部轮换图")
    public List<Carousel> findAll(){
        List<Carousel> carouselList = carouselService.findAll();
        System.out.println(carouselList);
        return carouselList;
    }
}
