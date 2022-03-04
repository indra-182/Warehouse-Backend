package com.example.Warehouse.controller;

import com.example.Warehouse.model.Warehouse;
import com.example.Warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/get")
    public ResponseEntity<List<Warehouse>> showAllWarehouse(){
        List<Warehouse> lWarehouse =warehouseService.showAll();
        return new ResponseEntity<>(lWarehouse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<List<Warehouse>> createWarehouse(@RequestBody Warehouse warehouse) {
        List<Warehouse> lWarehouse = warehouseService.createWarehouse(warehouse);
        return new ResponseEntity<>(lWarehouse, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Warehouse warehouse) {
        return new ResponseEntity<>(warehouseService.update(warehouse), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        warehouseService.deleteWarehouse(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Warehouse>> find(@PathVariable("id")String id){
        return new ResponseEntity<>(warehouseService.findWarehouse(id),HttpStatus.OK);
    }
}
