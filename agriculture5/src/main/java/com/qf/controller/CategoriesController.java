package com.qf.controller;

import com.qf.domain.Categories;
import com.qf.service.ICategoriesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    private ICategoriesService categoriesService;

    @GetMapping(value = "/findAll")
    @ApiOperation("查询所有总类接口")
    public List<Categories> findAll() {
        return categoriesService.findAll();
    }
}
