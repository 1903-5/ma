//package com.qf.controller;
//
//import com.qf.dao.ProductRepository;
//import com.qf.domain.AgricultureProduct;
//import com.qf.domain.AgricultureProduct1;
//import com.qf.service.ProductService;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@RestController
//@ResponseBody
//@RequestMapping("/findNameLike")
//public class ProductController {
//
//    @Autowired
//    private ProductService productService;
//
//    //查询所有商品
//    @GetMapping(value = "/product")
//    @ApiOperation("查询所有产品")
//    public List<AgricultureProduct1> findAll() {
//        return productService.findAll();
//    }
//
//    /* //模糊查询
//     @GetMapping(value = "/findname/{productName}/{productBrand}")
//     @ApiOperation("模糊查询所有商品")
//     public List<AgricultureProduct> findByNameLike(@PathVariable(value = "productName") String productName) {
//         return productRepository.findByProductNameLike(productName);
//     }*/
//    @GetMapping(value = "/findByNameLike")
//    @ApiOperation("模糊查询所有产品")
//    public Set<AgricultureProduct1> findByNameLike(String name) {
//        AgricultureProduct1 agr = new AgricultureProduct1();
//        AgricultureProduct1 agr1 = new AgricultureProduct1();
//        AgricultureProduct1 agr2 = new AgricultureProduct1();
//        agr.setProductName(name);
//        agr1.setProductPlace(name);
//        agr2.setProductBrand(name);
//        List<AgricultureProduct1> list = productService.example(agr);
//        List<AgricultureProduct1> list1 = productService.example(agr1);
//        List<AgricultureProduct1> list2 = productService.example(agr2);
//        Set<AgricultureProduct1> agrlist = new HashSet<>();
//        agrlist.addAll(list);
//        agrlist.addAll(list1);
//        agrlist.addAll(list2);
//        return agrlist;
//    }
//}
