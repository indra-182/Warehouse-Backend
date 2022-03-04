package com.example.Warehouse.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public interface DetailsTable {

    String getWarehouseName();
    String getWarehouseAddress();
    String getGoodsName();
    Integer getGoodsStock();


}
