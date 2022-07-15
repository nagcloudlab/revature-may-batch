package com.example.rest;


import com.example.entity.Reimbursement;
import com.example.rest.dto.ReimbursementRequest;
import com.example.service.ReimbursementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reimbursement")
public class ReimbursementController {

    private final ReimbursementService reimbursementService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ReimbursementRequest request) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String empId = userDetails.getUsername();
        Reimbursement reimbursement = reimbursementService.create(empId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(reimbursement);
    }

}
