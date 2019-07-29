package com.qf.dao;

import com.qf.domain.CommonProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface CommenDao {
    List<CommonProduct> selectCommen(@Param("pid") Integer pid);
}
