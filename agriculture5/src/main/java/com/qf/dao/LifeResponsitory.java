package com.qf.dao;

import com.qf.domain.Life;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface LifeResponsitory extends JpaRepository<Life,Serializable> {
    List<Life> findByid(int id);
    List<Life> findAll();
}