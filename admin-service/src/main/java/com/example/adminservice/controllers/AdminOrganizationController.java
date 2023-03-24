package com.example.adminservice.controllers;


import com.example.adminservice.feignClients.OrganizationFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/organization")
@RequiredArgsConstructor
public class AdminOrganizationController {

    private final OrganizationFeignClient organizationClient;

    @PostMapping("/allow")
    public HttpStatus allowOrganizationToSellProducts(@RequestParam("organizationId") Long organizationId) {
        return organizationClient.allowOrganizationToSellProducts(organizationId);
    }

    @PostMapping
    public HttpStatus allowProductRequest(@RequestParam("productRequestId") Long productRequestId) {
        return organizationClient.allowProductRequest(productRequestId);
    }
}
