package com.example.backend_apis.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendApisController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Backend Engineer Tasks";
    }

    @GetMapping("/swaraj")
    public String swaraj() {
        return "Hello swaraj!";
    }
}
