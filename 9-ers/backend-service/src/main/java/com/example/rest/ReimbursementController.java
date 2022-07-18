package com.example.rest;


import com.example.entity.Reimbursement;
import com.example.entity.Status;
import com.example.repository.ReimbursementRepository;
import com.example.rest.dto.ReimbursementRequest;
import com.example.rest.dto.UpdateReimbursementRequest;
import com.example.service.ReimbursementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/api/reimbursements")
public class ReimbursementController {

    private final ReimbursementService reimbursementService;
    private final ReimbursementRepository reimbursementRepository;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ReimbursementRequest request) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String empId = userDetails.getUsername();
        Reimbursement reimbursement = reimbursementService.create(empId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(reimbursement);
    }

    @GetMapping
    public ResponseEntity<?> get() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String empId = userDetails.getUsername();
        boolean isManager=userDetails.getAuthorities().stream().anyMatch(ga->ga.getAuthority().equals("MANAGER"));
        List<Reimbursement> reimbursements = null;
        if(isManager){
            reimbursements=reimbursementService.getAll();
        }else{
            reimbursements=reimbursementService.getRequestsByEmpId(empId);
        }
        return ResponseEntity.status(HttpStatus.OK).body(reimbursements);
    }

    @PatchMapping
    public ResponseEntity<?> patch(@RequestBody UpdateReimbursementRequest request) {
        Reimbursement reimbursement=reimbursementRepository.findById(request.getId()).get();
        reimbursement.setStatus(Status.valueOf(request.getStatus()));
        reimbursement=reimbursementRepository.save(reimbursement);
        return ResponseEntity.status(HttpStatus.OK).body(reimbursement);
    }

}
