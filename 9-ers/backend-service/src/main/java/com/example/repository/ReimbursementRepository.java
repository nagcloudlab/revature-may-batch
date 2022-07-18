package com.example.repository;

import com.example.entity.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReimbursementRepository extends JpaRepository<Reimbursement,Integer> {

    @Query("from Reimbursement r where r.user.empId=:empId")
    List<Reimbursement> findRequestsByEmpId(String empId);

}
