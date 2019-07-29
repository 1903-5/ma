//package com.qf.service.impl;
//import com.qf.dao.ProductRepository;
//import com.qf.domain.AgricultureProduct;
//import com.qf.domain.AgricultureProduct1;
//import com.qf.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.ExampleMatcher;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class ProductServiceImpl implements ProductService {
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Override
//    public List<AgricultureProduct1> example(AgricultureProduct1 product) {
//        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("productName", ExampleMatcher.GenericPropertyMatchers.contains())
//                .withMatcher("productPlace", ExampleMatcher.GenericPropertyMatchers.contains()).withMatcher("productBrand", ExampleMatcher.GenericPropertyMatchers.contains());
//        Example<AgricultureProduct1> of = Example.of(product, exampleMatcher);
//        List<AgricultureProduct1> list = productRepository.findAll(of);
//        return list;
//    }
//
//    @Override
//    public List<AgricultureProduct1> findAll() {
//        return productRepository.findAll();
//    }
//
//}
//
//
