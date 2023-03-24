package com.example.organizationservice.services;


import com.example.organizationservice.entity.ProductRequest;
import com.example.organizationservice.feignClients.ProductFeignClient;
import com.example.organizationservice.repositories.ProductRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductRequestService {

    private final ProductRequestRepository productRequestRepository;
    private final ProductFeignClient productClient;
    private final OrganizationService organizationService;

    public ProductRequest getProductRequestById(Long id) {
        return productRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such product"));
    }
    @Transactional(readOnly = false)
    public void saveNewProductRequest(ProductRequest productRequest) {
        productRequestRepository.save(productRequest);
    }

    public void allowProductRequest(Long productRequestId) {
        ProductRequest productRequest = getProductRequestById(productRequestId);
        boolean allow = organizationService.isOrganizationCanSellProducts(productRequest.getOrganizationId());
        if (!allow)
            throw new RuntimeException("organization can not register products");
        productClient.addNewProduct(productRequest);
    }
}
