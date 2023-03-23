package com.example.adminservice.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/admin/orders")
public class AdminOrderController {


    @GetMapping("/{userid}")
    public List<String> getOrderHistoryOfUser(@PathVariable String userid) {
        return Collections.emptyList();
    }
}
