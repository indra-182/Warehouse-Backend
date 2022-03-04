package com.example.Warehouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "mst_warehouse")
public class Warehouse {

    @Id
    private String id;
    private String warehouseName;
    private String warehouseAddress;
    private Long warehousePhone;

    public String getId() {
        if (id == null || id.equals("")) {
            id = UUID.randomUUID().toString();
        }
        return id;

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public Long getWarehousePhone() {
        return warehousePhone;
    }

    public void setWarehousePhone(Long warehousePhone) {
        this.warehousePhone = warehousePhone;
    }
}
