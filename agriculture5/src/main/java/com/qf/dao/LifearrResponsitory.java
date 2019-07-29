package com.qf.dao;


import com.qf.domain.Lifearr;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface LifearrResponsitory extends JpaRepository<Lifearr, Serializable> {
    List<Lifearr> findBylid(int lid);
}
