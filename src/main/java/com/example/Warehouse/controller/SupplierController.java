package com.example.Warehouse.controller;

import com.example.Warehouse.model.Supplier;
import com.example.Warehouse.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;


    @GetMapping("/get")
    public ResponseEntity<List<Supplier>> showAllSupplier() {
        List<Supplier> lSupplier = supplierService.showAll();
        return new ResponseEntity<>(lSupplier, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<List<Supplier>> createSupplier(@RequestBody Supplier supplier) {
        List<Supplier> lSupplier = supplierService.createSupplier(supplier);
        return new ResponseEntity<>(lSupplier, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Supplier supplier) {
        return new ResponseEntity<>(supplierService.update(supplier), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        supplierService.deleteSupplier(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Supplier>> find(@PathVariable("id") String id) {
        return new ResponseEntity<>(supplierService.findSupplier(id), HttpStatus.OK);
    }
}

