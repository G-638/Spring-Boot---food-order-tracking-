package com.example.demo.service;

import com.example.demo.model.Branch;
import com.example.demo.model.FoodItems;
import com.example.demo.model.TableOrder;
import com.example.demo.model.User;
import com.example.demo.repository.BranchRepo;
import com.example.demo.repository.FoodOrderRepo;
import com.example.demo.repository.TableOrderRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    UserRepo userRepo;

    @Autowired
    BranchRepo branchRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<FoodItems> findAllTableData(){
        return foodOrderRepo.findAll();
    }

    public ArrayList<TableOrder> findByTableId(String tableid){
        return tableOrderRepo.findByTableId(tableid);
    }

    public List<TableOrder> findAllTableInBranch(String branch){
        return tableOrderRepo.findByBranch(branch);
    }

     public HashSet<String> getOrderedTableId(String branch){
        return tableOrderRepo.getOrderedTable(branch);
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

    public void saveManagerData(){
        userRepo.save(new User("Ram", "ram@gmail.com", passwordEncoder.encode("Sathish@123"), UUID.randomUUID().toString(), "manager", "b1,b2", "Male", "No5,selvam st,perungudi,chennai-600113","6543218976"));
        userRepo.save(new User("Ramu", "ramu@gmail.com", passwordEncoder.encode("Sathish@123"), UUID.randomUUID().toString(), "manager", "b3,b4", "Male", "No5,sanathi st,perungudi,chennai-600113","6234218976"));
        userRepo.save(new User("Raj", "raj@gmail.com", passwordEncoder.encode("Sathish@123"), UUID.randomUUID().toString(), "manager", "b5,b6", "Male", "No5,ramar st,perungudi,chennai-600113","6543234976"));
    }

    public void saveBranchesData(){
        branchRepo.save(new Branch("b1","K.K.NAGAR","1st sector, K.K.nagar, chennai-600078", "+914424747755"));
        branchRepo.save(new Branch("b2","T.NAGAR","14, Mahalakshmi st, T.nagar, chennai-600017", "+914424345577"));
        branchRepo.save(new Branch("b3","VADAPALANI-I","15, Amman kovil st, Vadapalani, chennai-600026", "+914424805577"));
        branchRepo.save(new Branch("b4","VADAPALANI-II","230, N.S.K.Salai, Vadapalani, chennai-600026", "+914424817866"));
        branchRepo.save(new Branch("b5","EGMORE","21, Kennetlene, Egmore, chennai-600008", "+914424192055"));
        branchRepo.save(new Branch("b6","PORUR","1, Sapthagiri Nagar, Arcot Road, Porur, chennai-600116", "+914424762211"));
    }
}
