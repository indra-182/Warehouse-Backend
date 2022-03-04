package com.example.Warehouse.service;

import com.example.Warehouse.model.Warehouse;
import com.example.Warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<Warehouse> showAll() {
        return warehouseRepository.findAll();
    }

    public List<Warehouse> createWarehouse(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
        return showAll();
    }

    public Warehouse update(Warehouse wh) {
        warehouseRepository.save(wh);
        return wh;
    }

    public void deleteWarehouse(String id) {
        warehouseRepository.deleteById(id);
    }

    public Optional<Warehouse> findWarehouse(String id) {
        return warehouseRepository.findById(id);
    }

}