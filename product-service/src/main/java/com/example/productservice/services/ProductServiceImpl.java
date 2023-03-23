package com.example.productservice.services;


import com.example.productservice.dto.DiscountDTO;
import com.example.productservice.dto.ProductDTO;
import com.example.productservice.entity.Discount;
import com.example.productservice.entity.Product;
import com.example.productservice.feignClients.OrderClient;
import com.example.productservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final OrderClient orderClient;
    private final ProductRepository productRepository;
    private final DiscountService discountService;


    @Override
    public Product findProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("no such product"));
    }

    @Override
    public List<Product> findProductsByOrganization(String organization) {
        return productRepository.findProductsByOrganization(organization)
                .orElseThrow(() -> new RuntimeException("no such product with that name of org."));
    }

    @Override
    public List<Product> findProductsByProductName(String productName) {
        return productRepository.findProductsByProductName(productName)
                .orElseThrow(() -> new RuntimeException("no such products with that product name"));
    }

    @Override
    @Transactional
    public void addProduct(ProductDTO product) {
        Product newProduct = new Product(product);
        productRepository.save(newProduct);
    }

    @Override
    @Transactional
    public void updateProduct(Long updatableId, ProductDTO product) {
        Product updatableProduct = findProductById(updatableId);
        updatableProduct.setProductName(product.getProductName());
        updatableProduct.setProductDescription(product.getProductDescription());
        updatableProduct.setProductPrice(product.getProductPrice());
        updatableProduct.setAmount(product.getAmount());
        updatableProduct.setOrganization(product.getOrganization());
        productRepository.save(updatableProduct);
    }

    @Override
    @Transactional
    public void addDiscountToProduct(Long productId, DiscountDTO discount) {
        Product product = findProductById(productId);
        product.setProductDiscount(discountService.saveDiscount(discount));
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void addDiscountToGroupOfProductByProductName(String productName, DiscountDTO discount) {
        List<Product> products = findProductsByProductName(productName);
        Discount newDiscount = discountService.saveDiscount(discount);
        products.stream().peek(a -> a.setProductDiscount(newDiscount)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addDiscountToGroupOfProductByOrganization(String organization, DiscountDTO discount) {
        List<Product> products = findProductsByOrganization(organization);
        Discount newDiscount = discountService.saveDiscount(discount);
        products.stream().peek(a -> a.setProductDiscount(newDiscount)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateDiscountToProduct(Long updatableId, DiscountDTO discount) {
        Product product = findProductById(updatableId);
        Discount newDiscount = discountService.saveDiscount(discount);
        product.setProductDiscount(newDiscount);
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void updateDiscountToGroupOfProductByProductName(String productName, DiscountDTO discount) {
        List<Product> products = findProductsByProductName(productName);
        Discount newDiscount = discountService.saveDiscount(discount);
        products.stream().peek(a -> a.setProductDiscount(newDiscount)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateDiscountToGroupOfProductByOrganization(String organization, DiscountDTO discount) {
        List<Product> products = findProductsByOrganization(organization);
        Discount newDiscount = discountService.saveDiscount(discount);
        products.stream().peek(a -> a.setProductDiscount(newDiscount)).collect(Collectors.toList());
    }

    @Transactional
    public void buyProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("product is not found"));

        if (product.getAmount() == 0) {
            throw new RuntimeException("product amount is 0");
        }
        product.setAmount(product.getAmount() - 1);
        orderClient.addOrder(productId);
        productRepository.save(product);
    }

}
