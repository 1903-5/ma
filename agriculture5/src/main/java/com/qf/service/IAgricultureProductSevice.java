package com.qf.service;
import com.qf.domain.AgricultureProduct;
import com.qf.domain.CommonProduct;
import java.util.List;

public interface IAgricultureProductSevice {
    List<AgricultureProduct> findByCategoriesId(Integer categoriesId);

    List<AgricultureProduct> findBySubclassId(Integer subclassId);

    Object selectone(Integer id);

    List<CommonProduct> selectCommen(Integer pid);

    List<AgricultureProduct> findAll();
    List<AgricultureProduct> findLike(String productName);
    AgricultureProduct findAllById(Integer productId);
    public List<AgricultureProduct> findBySortId(Integer sortId);
//    List<AgricultureProduct> example(AgricultureProduct product);

}
