package com.example.Warehouse.repository;

import com.example.Warehouse.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods,String> {

}
