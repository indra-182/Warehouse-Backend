package com.example.Warehouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "mst_store")
public class Store {

    @Id
    private String id;
    private String storeName;
    private Long storePhone;

    public String getId() {
        if (id == null || id.equals("")) {
            id = UUID.randomUUID().toString();
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(Long storePhone) {
        this.storePhone = storePhone;
    }
}