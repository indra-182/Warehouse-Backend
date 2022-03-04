package com.example.Warehouse.controller;

import com.example.Warehouse.model.Store;
import com.example.Warehouse.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/get")
    public ResponseEntity<List<Store>> showAllStore() {
        List<Store> lStore = storeService.showAll();
        return new ResponseEntity<>(lStore, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<List<Store>> createStore(@RequestBody Store store) {
        List<Store> lStore = storeService.createStore(store);
        return new ResponseEntity<>(lStore, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Store store) {
        return new ResponseEntity<>(storeService.update(store), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        storeService.deleteStore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Store>> find(@PathVariable("id") String id) {
        return new ResponseEntity<>(storeService.findStore(id), HttpStatus.OK);
    }
}

