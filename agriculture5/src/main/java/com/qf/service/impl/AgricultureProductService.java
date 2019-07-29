package com.qf.service.impl;
import com.qf.dao.AgricultureProductDao;
import com.qf.dao.CommenDao;
import com.qf.domain.AgricultureProduct;
import com.qf.domain.CommonProduct;
import com.qf.service.IAgricultureProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AgricultureProductService implements IAgricultureProductSevice {
    @Autowired(required = false)
    private AgricultureProductDao agricultureProductDao;
    @Autowired(required = false)
    private CommenDao commenDao;
//    @Autowired(required = false)
//    private AgricultureProductRepository productRepository;

    @Override
    public List<AgricultureProduct> findByCategoriesId(Integer categoriesId) {
        return agricultureProductDao.findByCategoriesId(categoriesId);
    }

    @Override
    public List<AgricultureProduct> findBySubclassId(Integer subclassId) {
        return agricultureProductDao.findBySubclassId(subclassId);
    }
    @Override
    public Object selectone(Integer id) {
        return agricultureProductDao.selectone(id);
    }
    @Override
    public List<CommonProduct> selectCommen(Integer pid) {
        return commenDao.selectCommen(pid);
    }

    @Override
    public List<AgricultureProduct> findAll() {

        return agricultureProductDao.findAll();
    }

    @Override
    public List<AgricultureProduct> findLike(String productName) {
        return agricultureProductDao.findLike(productName);
    }

    @Override
    public AgricultureProduct findAllById(Integer productId) {
        return agricultureProductDao.findAllById(productId);
    }
//    @Override
//    public List<AgricultureProduct> example(AgricultureProduct product) {
//        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("productName", ExampleMatcher.GenericPropertyMatchers.contains())
//                .withMatcher("productPlace", ExampleMatcher.GenericPropertyMatchers.contains()).withMatcher("productBrand", ExampleMatcher.GenericPropertyMatchers.contains());
//        Example<AgricultureProduct> of = Example.of(product, exampleMatcher);
//        List<AgricultureProduct> list = productRepository.findAll(of);
//        return list;
//    }

    @Override
    public List<AgricultureProduct> findBySortId(Integer sortId) {
        return agricultureProductDao.findBySortId(sortId);
    }
}
