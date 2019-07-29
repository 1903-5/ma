package com.qf.controller;

import com.qf.dao.SubclassRepository;
import com.qf.domain.Subclass;
import com.qf.service.ISubclassService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/subclass")
public class SubclassController {
    @Autowired
    private SubclassRepository subclassRepository;
    @Autowired
    private ISubclassService subclassService;


    // 查询所有子类产品
    @GetMapping(value = "/findAllsubclass")
    @ApiOperation("查询全部子分类")
    public List<Subclass> findAll() {
        return subclassRepository.findAll();
    }

    @GetMapping(value = "/findBycategoriesId")
    @ApiOperation("根据总类ID查询子分类")
    public List<Subclass> findBycategoriesId(@RequestParam Integer categoriesId) {
        List<Subclass> subclasses = subclassService.findByCategoriesId(categoriesId);
        return subclasses;
    }

}
