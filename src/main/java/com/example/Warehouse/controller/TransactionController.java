package com.example.Warehouse.controller;

import com.example.Warehouse.model.DTO.TransactionDTO;
import com.example.Warehouse.model.Transaction;
import com.example.Warehouse.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trans")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/supplier2warehouse")
    public ResponseEntity<Object> supplierToWarehouse(@RequestBody Transaction data){
        Object send = transactionService.supplierToWarehouse(data);
        if(data.equals(false)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(send,HttpStatus.OK);
    }

    @PostMapping("/warehouse2warehouse")
    public ResponseEntity<Object> warehouseToWarehouse(@RequestBody Transaction data){
        Object send = transactionService.warehouseToWarehouse(data);
        if(data.equals(false)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(send,HttpStatus.OK);
    }

    @PostMapping("/warehouse2store")
    public ResponseEntity<Object> warehouseToStore(@RequestBody Transaction data){
        Object send = transactionService.warehouseToStore(data);
        if(data.equals(false)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(send,HttpStatus.OK);
    }

    @GetMapping("/showalltrans")
    public List<TransactionDTO>showAllTrx(){
        return transactionService.reportAllTransaction();
    }
}