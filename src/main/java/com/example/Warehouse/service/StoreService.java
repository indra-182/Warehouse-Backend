package com.example.Warehouse.service;

import com.example.Warehouse.model.Store;
import com.example.Warehouse.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> showAll() {
        return storeRepository.findAll();
    }

    public List<Store> createStore(Store store) {
        storeRepository.save(store);
        return showAll();
    }

    public Store update(Store st) {
        storeRepository.save(st);
        return st;
    }

    public void deleteStore(String id) {
        storeRepository.deleteById(id);
    }

    public Optional<Store> findStore(String id) {
        return storeRepository.findById(id);
    }

}