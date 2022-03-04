package com.example.Warehouse.service;

import com.example.Warehouse.model.DTO.TransactionDTO;
import com.example.Warehouse.model.Details;
import com.example.Warehouse.model.Goods;
import com.example.Warehouse.model.Transaction;
import com.example.Warehouse.repository.DetailsRepository;
import com.example.Warehouse.repository.GoodsRepository;
import com.example.Warehouse.repository.TransactionRepository;
import com.example.Warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.type.DeclaredType;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private DetailsRepository detailsRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    public Object supplierToWarehouse(Transaction data) {
        List<Details> details = detailsRepository.findAllByWarehouseId(data.getIdTo());
        for (Details d : details) {
            if (d.getGoodsId().equals(data.getGoodsId())) {
                int jumlah = d.getGoodsStock() + data.getGoodsQuantity();
                d.setGoodsStock(jumlah);
                detailsRepository.save(d);
            }
        }
        Goods goods = goodsRepository.findById(data.getGoodsId()).orElse(null);
        if (goods != null) {
            int jumlah = goods.getGoodsStock() + data.getGoodsQuantity();
            goods.setGoodsStock(jumlah);
            goodsRepository.save(goods);

            data.setType("supplier to warehouse");
            data.setGoodsDelivery(LocalDate.now());
            transactionRepository.save(data);
            return "ok";
        }
        return false;
    }

    public Object warehouseToWarehouse(Transaction data) {
        List<Details> from = detailsRepository.findAllByWarehouseId(data.getIdFrom());
        for (Details d : from) {
            if (d.getGoodsId().equals(data.getGoodsId())) {
                if ((d.getGoodsStock() < 0) || (d.getGoodsStock()- data.getGoodsQuantity()<0)) {
                   return false;
                }
                int jumlah = d.getGoodsStock() - data.getGoodsQuantity();
                d.setGoodsStock(jumlah);
                detailsRepository.save(d);
            }
        }
        List<Details> to = detailsRepository.findAllByWarehouseId(data.getIdTo());
        for (Details d : to) {
            if (d.getGoodsId().equals(data.getGoodsId())) {
                int jumlah = d.getGoodsStock() + data.getGoodsQuantity();
                d.setGoodsStock(jumlah);
                detailsRepository.save(d);

                data.setType("warehouse to warehouse");
                data.setGoodsDelivery(LocalDate.now());
                transactionRepository.save(data);
                return "ok";
            }
        }
        return false;
    }

    public Object warehouseToStore(Transaction data){
        List<Details> from = detailsRepository.findAllByWarehouseId(data.getIdFrom());
        for (Details d : from) {
            if (d.getGoodsId().equals(data.getGoodsId())) {
                if ((d.getGoodsStock() < 0) || (d.getGoodsStock()- data.getGoodsQuantity()<0)) {
                    return false;
                }
                int jumlah = d.getGoodsStock() - data.getGoodsQuantity();
                d.setGoodsStock(jumlah);
                detailsRepository.save(d);
            }
        }
        Goods goods = goodsRepository.findById(data.getGoodsId()).orElse(null);
        if (goods != null) {
            int jumlah = goods.getGoodsStock() - data.getGoodsQuantity();
            goods.setGoodsStock(jumlah);
            goodsRepository.save(goods);

            data.setType("warehouse to store");
            data.setGoodsDelivery(LocalDate.now());
            transactionRepository.save(data);
            return "ok";
        }
        return false;
    }

    public List<TransactionDTO> reportAllTransaction(){
        return detailsRepository.findAllTransaction();
    }

}
