package com.qf.dao;

import com.qf.domain.Subclass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubclassDao {
    public List<Subclass> findByCategoriesId(@Param("catid") Integer categoriesId);
}
