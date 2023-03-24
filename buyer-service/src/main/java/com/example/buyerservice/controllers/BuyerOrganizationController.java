package com.example.buyerservice.controllers;


import com.example.buyerservice.dto.OrganizationDTO;
import com.example.buyerservice.dto.ProductRequestDTO;
import com.example.buyerservice.feignClient.OrganizationFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buyer/organization")
@RequiredArgsConstructor
public class BuyerOrganizationController {

    private final OrganizationFeignClient organizationClient;

    @PostMapping("/new")
    public HttpStatus registerNewOrganization(@RequestHeader("user-id") Long userId,
                                              @RequestBody OrganizationDTO organization) {
        return organizationClient.registerNewOrganization(userId, organization);
    }

    @PostMapping("/newproduct")
    public HttpStatus registerNewProduct(@RequestBody ProductRequestDTO product) {
        return organizationClient.addNewOrganizationProduct(product);
    }

}
