package com.example.Warehouse.controller;

import com.example.Warehouse.model.Goods;
import com.example.Warehouse.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/get")
    public ResponseEntity<List<Goods>> showAllGoods(){
        List<Goods> lGoods =goodsService.showAll();
        return new ResponseEntity<>(lGoods, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<List<Goods>> createGoods(@RequestBody Goods goods) {
        List<Goods> lGoods = goodsService.createGoods(goods);
        return new ResponseEntity<>(lGoods, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Goods goods) {
        return new ResponseEntity<>(goodsService.update(goods), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        goodsService.deleteGoods(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Goods>> find(@PathVariable("id")String id){
        return new ResponseEntity<>(goodsService.findGoods(id),HttpStatus.OK);
    }
}
