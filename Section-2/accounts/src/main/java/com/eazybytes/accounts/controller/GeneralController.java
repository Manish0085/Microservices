package com.eazybytes.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {


    @GetMapping
    public String getString(){
        return "Learning Microservices";
    }
}
