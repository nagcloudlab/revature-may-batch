package com.example.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class ResourceController {

    @GetMapping(value = "/api/public-resource",produces = {"text/plain"})
    public String publicResource() {
        return "PUBLIC_RESOURCE";
    }


    @GetMapping(value = "/api/private-resource",produces = {"text/plain"})
    public String privateResource() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        User user = (User) authentication.getPrincipal();
        System.out.println(user.getUsername());
        user.getAuthorities().forEach(ga->{
            System.out.println(ga.getAuthority());
        });

        return "PRIVATE_RESOURCE";
    }

}
