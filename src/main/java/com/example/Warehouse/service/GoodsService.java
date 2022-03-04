package com.example.Warehouse.service;

import com.example.Warehouse.model.Goods;
import com.example.Warehouse.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public List<Goods> showAll() {
        return goodsRepository.findAll();
    }

    public List<Goods> createGoods(Goods goods) {
        goods.setGoodsStock(0);
        goodsRepository.save(goods);


        return showAll();
    }

    public Goods update(Goods gd) {
        goodsRepository.save(gd);
        return gd;
    }

    public void deleteGoods(String id) {
        goodsRepository.deleteById(id);
    }

    public Optional<Goods> findGoods(String id) {
        return goodsRepository.findById(id);
    }

}