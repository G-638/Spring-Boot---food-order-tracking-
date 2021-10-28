package com.example.demo.repository;

import com.example.demo.model.TableOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;

@Repository
public interface TableOrderRepo extends JpaRepository<TableOrder, String> {

    //DML
    @Transactional
    @Modifying
    @Query("delete from TableOrder t where t.tableId=:tableId")
    void resetTable(@Param("tableId") String tableId);

    //DQL
    @Query("select t from TableOrder t where t.tableId=:tableId")
    ArrayList<TableOrder> findByTableId(@Param("tableId") String tableId);

//    @Modifying
//    @Query("update TableOrder t set t.qty=:qty where t.tableId=:tableId && t.uid=:uid")
//    void updateQty(@Param("tableId") String tableId, @Param("uid") String uid, @Param("qty") int qty);

    //DQL
    @Query("select tableId from TableOrder")
    HashSet<String> getOrderedTable();

}
