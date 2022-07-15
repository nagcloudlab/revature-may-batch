package com.example.repository;

import com.example.entity.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReimbursementRepository extends JpaRepository<Reimbursement,Integer> {
}
