package com.qf.controller;

import com.qf.dao.LifearrResponsitory;
import com.qf.domain.Lifearr;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@RestController
public class LifearrController {
    @Autowired
    private LifearrResponsitory lifearrResponsitory;

    @RequestMapping(value = "/findBylid",method = RequestMethod.GET)
    @ApiOperation("盒区生活：根据id查对应简介")
    public List<Lifearr> findBylid(@RequestParam Integer lid) {
        return lifearrResponsitory.findBylid(lid);
    }
}
