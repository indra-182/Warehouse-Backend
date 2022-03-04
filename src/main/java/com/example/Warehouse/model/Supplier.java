package com.example.Warehouse.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table (name="mst_supplier")
public class Supplier {

    @Id
    private String id;
    private String supplierName;
    private Long supplierPhone;

    public String getId() {
        if (id == null || id.equals("")) {
            id = UUID.randomUUID().toString();
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Long getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(Long supplierPhone) {
        this.supplierPhone = supplierPhone;
    }
}
