package com.qf.controller;
import com.qf.dao.LifeResponsitory;
import com.qf.domain.Life;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@ResponseBody
@RestController
public class LifeController {
    @Autowired
    private LifeResponsitory lifeResponsitory;

    @RequestMapping(value = "/findByid",method = RequestMethod.GET)
    @ApiOperation("根据Id查询全部盒区生活商品")
    public List<Life> findByid(int id ) {

        return lifeResponsitory.findByid(id);
    }
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ApiOperation("查询全部盒区生活商品")
    public  List<Life> findAll(){
        return lifeResponsitory.findAll();
    }
}