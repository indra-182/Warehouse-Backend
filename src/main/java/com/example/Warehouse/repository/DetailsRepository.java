package com.example.Warehouse.repository;

import com.example.Warehouse.model.DTO.TransactionDTO;
import com.example.Warehouse.model.Details;
import com.example.Warehouse.model.DTO.DetailsTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetailsRepository extends JpaRepository<Details,String> {

    @Query(value = "select w.warehouse_name as warehouseName,w.warehouse_address as warehouseAddress,g.goods_name as goodsName,d.goods_stock as goodsStock from trx_details d\n" +
            "inner join mst_goods g on d.goods_id = g.id\n" +
            "full join mst_warehouse w on d.warehouse_id = w.id",nativeQuery = true)
    List<DetailsTable> showAllDetails();

    List<Details> findAllByWarehouseId(String warehouseId);

    @Query(value = "select  t.goods_delivery as date, t.goods_quantity as quantity,\n" +
            "t.type as type,d.goods_name as goodsName,\n" +
            "concat(wf.warehouse_name ,'', st.store_name) as from,\n" +
            "concat(wt.warehouse_name ,'', sup.supplier_name) as to\n" +
            "from trx_transaction t\n" +
            "inner join mst_goods d on t.goods_id = d.id\n" +
            "left join mst_warehouse wt on t.id_from = wt.id \n" +
            "left join mst_warehouse wf on t.id_to = wf.id \n" +
            "left join mst_supplier sup on t.id_from = sup.id\n" +
            "left join mst_store st on st.id = t.id_to",nativeQuery = true)
    List<TransactionDTO> findAllTransaction();
}
