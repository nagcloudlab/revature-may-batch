package com.example.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping(value = "/api/greet/{lang}")
    public String doGreet(@PathVariable String lang) {
        if (lang.equals("en")) {
            return "Hello";
        }
        if (lang.equals("tn")) {
            return "Vanakkam";
        }
        return "Unknown language";
    }

}
