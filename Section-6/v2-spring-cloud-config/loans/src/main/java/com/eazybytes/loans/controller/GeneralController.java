package com.eazybytes.loans.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {

    @GetMapping
    public String getMessage(){
        return "Hello loan service";
    }
}
