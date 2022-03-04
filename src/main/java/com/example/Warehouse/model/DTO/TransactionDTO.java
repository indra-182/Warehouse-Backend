package com.example.Warehouse.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public interface TransactionDTO {

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate getDate();
    Long getQuantity();
    String getType();
    String getFrom();
    String getTo();
}
