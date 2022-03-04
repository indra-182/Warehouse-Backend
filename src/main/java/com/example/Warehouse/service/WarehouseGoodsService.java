package com.example.Warehouse.service;

import com.example.Warehouse.model.Details;
import com.example.Warehouse.model.DTO.DetailsTable;
import com.example.Warehouse.repository.DetailsRepository;
import com.example.Warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseGoodsService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private DetailsRepository detailsRepository;

    public void createWhgoods(Details data){
        data.setGoodsStock(0);
        detailsRepository.save(data);
    }

    public List<DetailsTable> findTable(){
        return detailsRepository.showAllDetails();
    }

}
