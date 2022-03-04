package com.example.Warehouse.service;

import com.example.Warehouse.model.Supplier;
import com.example.Warehouse.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> showAll() {
        return supplierRepository.findAll();
    }

    public List<Supplier> createSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
        return showAll();
    }

    public Supplier update(Supplier sup) {
        supplierRepository.save(sup);
        return sup;
    }

    public void deleteSupplier(String id) {
        supplierRepository.deleteById(id);
    }

    public Optional<Supplier> findSupplier(String id) {
        return supplierRepository.findById(id);
    }

}
