package com.qf.dao;

import com.qf.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopResponsitory extends JpaRepository<Shop,Integer> {
//        int deleteByShopId(Integer shopId);
}
