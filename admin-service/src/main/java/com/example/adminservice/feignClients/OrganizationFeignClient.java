package com.example.adminservice.feignClients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("organization-service")
public interface OrganizationFeignClient {
    @PostMapping("/organization/admin/product/allow")
    HttpStatus allowOrganizationToSellProducts(@RequestParam("organizationId") Long organizationId);

    @PostMapping("/organization/admin/allow")
    HttpStatus allowProductRequest(@RequestParam("productRequestId") Long productRequestId);
}
