package com.example.service;

import com.example.entity.Reimbursement;
import com.example.entity.Status;
import com.example.entity.User;
import com.example.repository.ReimbursementRepository;
import com.example.repository.UserRepository;
import com.example.rest.dto.ReimbursementRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class ReimbursementService {

    private final UserRepository userRepository;
    private final ReimbursementRepository reimbursementRepository;

    @Transactional
    public Reimbursement create(String empId, ReimbursementRequest request) {
        User user = userRepository.findByEmpId(empId);
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(request.getAmount());
        reimbursement.setStatus(Status.PENDING);
        reimbursement.setDateTime(new Date());
        reimbursement.setUser(user);
        return reimbursementRepository.save(reimbursement);

    }

}
