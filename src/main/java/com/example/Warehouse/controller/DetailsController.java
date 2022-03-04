package com.example.Warehouse.controller;

import com.example.Warehouse.model.DTO.TransactionDTO;
import com.example.Warehouse.model.Details;
import com.example.Warehouse.model.DTO.DetailsTable;
import com.example.Warehouse.service.WarehouseGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    private WarehouseGoodsService Service;

    @PostMapping("/create")
    public ResponseEntity<?> saveDetails(@RequestBody Details data){
        Service.createWhgoods(data);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<DetailsTable>> find(){
        return new ResponseEntity<>(Service.findTable(),HttpStatus.OK);
    }


}
