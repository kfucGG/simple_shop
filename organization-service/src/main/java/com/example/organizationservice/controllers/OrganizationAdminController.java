package com.example.organizationservice.controllers;


import com.example.organizationservice.dto.OrganizationDTO;
import com.example.organizationservice.entity.Organization;
import com.example.organizationservice.entity.ProductRequest;
import com.example.organizationservice.services.OrganizationService;
import com.example.organizationservice.services.ProductRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization/admin")
@RequiredArgsConstructor
public class OrganizationAdminController {

    private final OrganizationService organizationService;
    private final ProductRequestService productRequestService;

    @PostMapping("/product/allow")
    public HttpStatus allowOrganizationToSellProducts(@RequestParam("organizationId") Long organizationId) {
        organizationService.allowOrganizationSellProducts(organizationId);
        return HttpStatus.OK;
    }

    @PostMapping("/allow")
    public HttpStatus allowProductRequest(@RequestParam("productRequestId") Long productRequestId) {
        productRequestService.allowProductRequest(productRequestId);
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete")
    public HttpStatus deleteOrganization(@RequestParam("organizationId") Long organizationId) {
        organizationService.deleteOrganization(organizationId);
        return HttpStatus.OK;
    }
}
