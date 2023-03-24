package com.example.organizationservice.services;


import com.example.organizationservice.dto.OrganizationDTO;
import com.example.organizationservice.entity.Organization;
import com.example.organizationservice.entity.ProductRequest;
import com.example.organizationservice.repositories.OrganizationRepository;
import com.example.organizationservice.repositories.ProductRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    private final ProductRequestRepository productRequestRepository;


    @Override
    public Organization findOrganizationById(Long organizationId) {
        return organizationRepository.findById(organizationId)
                .orElseThrow(() -> new RuntimeException("organization does not exists"));
    }

    @Override
    public List<Organization> findOrganizationByOwnerId(Long ownerId) {
        return organizationRepository.findOrganizationByOwnerId(ownerId);
    }

    @Override
    @Transactional
    public void registerNewOrganization(OrganizationDTO organizationDTO, Long ownerId) {
        organizationRepository.save(new Organization(organizationDTO, ownerId));
    }

    @Override
    @Transactional
    public void registerNewProduct(ProductRequest product) {
        Organization organization = findOrganizationById(product.getOrganizationId());
        if (!organization.isWork())
            throw new RuntimeException("you can not register new product");
        productRequestRepository.save(product);
    }

    @Override
    public List<Organization> getAllUnregisteredOrganization() {
        return organizationRepository.findAllByWorkIsFalse();
    }

    @Override
    @Transactional
    public void allowOrganizationSellProducts(Long organizationId) {
        Organization organization = findOrganizationById(organizationId);
        organization.setWork(true);
        organizationRepository.save(organization);
    }

    @Override
    public boolean isOrganizationCanSellProducts(Long organizationId) {
        return findOrganizationById(organizationId).isWork();
    }

    @Override
    public void deleteOrganization(Long organizationId) {
        organizationRepository.deleteById(organizationId);
    }
}
