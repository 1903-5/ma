package com.qf.controller;

import com.qf.domain.CarouselInner;
import com.qf.service.ICarouselInnerServise;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/carousle")
@ResponseBody
public class CarouselInnerController {
    @Autowired
    private ICarouselInnerServise carouselInnerServise;
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ApiOperation("显示所有轮播图内部商品")
    public List<CarouselInner> findAll(){
        return carouselInnerServise.findAll();
    }
}
