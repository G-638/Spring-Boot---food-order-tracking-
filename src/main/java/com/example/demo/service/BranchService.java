package com.example.demo.service;

import com.example.demo.model.Branch;
import com.example.demo.repository.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BranchService {
    @Autowired
    BranchRepo branchRepo;

    public ArrayList<Branch> findBranchData(String branch){
        return branchRepo.findByBranch(branch);
    }

}

