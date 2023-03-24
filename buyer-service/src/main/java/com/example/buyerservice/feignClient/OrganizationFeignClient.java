package com.example.buyerservice.feignClient;


import com.example.buyerservice.dto.OrganizationDTO;
import com.example.buyerservice.dto.ProductRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("organization-service")
public interface OrganizationFeignClient {

    @PostMapping("/organization/users/new")
    HttpStatus registerNewOrganization(@RequestHeader("user-id") Long userId,
                                       @RequestBody OrganizationDTO organization);


    @PostMapping("/organization/users/newproduct")
    HttpStatus addNewOrganizationProduct(@RequestBody ProductRequestDTO product);
}
