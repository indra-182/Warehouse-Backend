package com.example.Warehouse.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "trx_transaction")
public class Transaction {

    @Id
    private String id;
    private String goodsId;
    private String idFrom;
    private String idTo;
    private String type;
    private int goodsQuantity;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDate goodsDelivery;


    public Transaction() {
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(String idFrom) {
        this.idFrom = idFrom;
    }

    public String getIdTo() {
        return idTo;
    }

    public void setIdTo(String idTo) {
        this.idTo = idTo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(int goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public LocalDate getGoodsDelivery() {
        return goodsDelivery;
    }

    public void setGoodsDelivery(LocalDate goodsDelivery) {
        this.goodsDelivery = goodsDelivery;
    }

}