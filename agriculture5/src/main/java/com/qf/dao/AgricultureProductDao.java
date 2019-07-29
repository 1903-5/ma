package com.qf.dao;

import com.qf.domain.AgricultureProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AgricultureProductDao {
    public List<AgricultureProduct> findByCategoriesId(@Param(value = "catid") Integer categoriesId);

    public List<AgricultureProduct> findBySubclassId(@Param(value = "subid") Integer subclassId);

//    AgricultureProduct selectByPrimaryKey(Integer id);

    Object selectone(Integer id);
    List<AgricultureProduct> findAll();
    List<AgricultureProduct> findLike(String productName);
    AgricultureProduct findAllById(Integer productId);
    public List<AgricultureProduct> findBySortId(@Param(value = "sortId") Integer sortId);
}
