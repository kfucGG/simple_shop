package com.example.organizationservice.services;

import com.example.organizationservice.dto.OrganizationDTO;
import com.example.organizationservice.entity.Organization;
import com.example.organizationservice.entity.ProductRequest;

import java.util.List;

public interface OrganizationService {

    Organization findOrganizationById(Long organizationId);
    List<Organization> findOrganizationByOwnerId(Long ownerId);
    void registerNewOrganization(OrganizationDTO organizationDTO, Long ownerId);
    void registerNewProduct(ProductRequest product);
    List<Organization> getAllUnregisteredOrganization();
    void allowOrganizationSellProducts(Long organizationId);
    boolean isOrganizationCanSellProducts(Long organizationId);

    void deleteOrganization(Long organizationId);
}
