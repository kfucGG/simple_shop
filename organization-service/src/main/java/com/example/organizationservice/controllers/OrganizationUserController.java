package com.example.organizationservice.controllers;


import com.example.organizationservice.dto.OrganizationDTO;
import com.example.organizationservice.entity.Organization;
import com.example.organizationservice.entity.ProductRequest;
import com.example.organizationservice.services.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization/users")
@RequiredArgsConstructor
public class OrganizationUserController {

    private final OrganizationService organizationService;


    @GetMapping
    public List<Organization> getAllUserOrganization(@RequestHeader("user-id") Long userId) {
        return organizationService.findOrganizationByOwnerId(userId);
    }

    @PostMapping("/new")
    public HttpStatus registerNewOrganization(@RequestHeader("user-id") Long userId,
                                              @RequestBody OrganizationDTO organization) {
        organizationService.registerNewOrganization(organization, userId);
        return HttpStatus.OK;
    }

    @PostMapping("/newproduct")
    public HttpStatus addNewOrganizationProduct(@RequestBody ProductRequest product) {
        organizationService.registerNewProduct(product);
        return HttpStatus.OK;
    }
}
