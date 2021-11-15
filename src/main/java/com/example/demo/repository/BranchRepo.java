package com.example.demo.repository;

import com.example.demo.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BranchRepo extends JpaRepository<Branch,Long> {

    @Query("select b from Branch b where b.branch=:branch")
    ArrayList<Branch> findByBranch(@Param("branch") String branch);
}
