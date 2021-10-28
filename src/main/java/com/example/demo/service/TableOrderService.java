package com.example.demo.service;

import com.example.demo.model.FoodItems;
import com.example.demo.model.TableOrder;
import com.example.demo.repository.FoodOrderRepo;
import com.example.demo.repository.TableOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class TableOrderService {

    @Autowired
    FoodOrderRepo foodOrderRepo;

    @Autowired
    TableOrderRepo tableOrderRepo;

    public List<FoodItems> findAllTableData(){
        return foodOrderRepo.findAll();
    }

    public ArrayList<TableOrder> findByTableId(String tableid){
        return tableOrderRepo.findByTableId(tableid);
    }

     public HashSet<String> getOrderedTableId(){
        return tableOrderRepo.getOrderedTable();
    }

    public void resetTableById(String tableId){
        tableOrderRepo.resetTable(tableId);
    }

    public void saveData(TableOrder tableOrder){
        tableOrderRepo.save(tableOrder);
    }


    public void save(){
        foodOrderRepo.save(new FoodItems( UUID.randomUUID().toString(),"Curd Rice", "Curd rice desc", 50, 0));
        foodOrderRepo.save(new FoodItems( UUID.randomUUID().toString(),"Plain Rice", "Plain rice desc", 50, 0));
        foodOrderRepo.save(new FoodItems( UUID.randomUUID().toString(),"Gobi Rice", "Gobi rice desc", 70, 0));
        foodOrderRepo.save(new FoodItems( UUID.randomUUID().toString(),"Veg Rice", "Veg rice desc", 60, 0));
        foodOrderRepo.save(new FoodItems( UUID.randomUUID().toString(),"Mushroom Rice", "Mushroom rice desc", 80, 0));
        foodOrderRepo.save(new FoodItems( UUID.randomUUID().toString(),"Chicken Rice", "Chicken rice desc", 90, 0));
    }
}
