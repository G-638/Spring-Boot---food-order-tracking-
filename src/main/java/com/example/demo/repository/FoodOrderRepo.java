package com.example.demo.repository;

import com.example.demo.model.FoodItems;
import com.example.demo.model.TableOrder;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FoodOrderRepo extends JpaRepository<FoodItems, Long> {
    @Query("select uid from FoodItems f where f.uid=:uid")
   ArrayList<FoodItems> findUniqueId(String uid);


}