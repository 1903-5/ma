package com.qf.controller;

import com.qf.domain.Sort;
import com.qf.service.ISortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sort")
@ResponseBody
public class SortController {
    @Autowired
    private ISortService sortService;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<Sort> findAll(){
        return sortService.findAll();
    }
}
