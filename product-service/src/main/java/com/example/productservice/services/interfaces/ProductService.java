package com.example.productservice.services.interfaces;

import com.example.productservice.dto.DiscountDTO;
import com.example.productservice.dto.ProductDTO;
import com.example.productservice.entity.Discount;
import com.example.productservice.entity.Product;

import java.util.List;

public interface ProductService {

    Product findProductById(Long productId);

    List<Product> findProductsByOrganization(Long organization);
    List<Product> findProductsByProductName(String productName);
    void addProduct(ProductDTO product);
    void updateProduct(Long updatableId, ProductDTO product);
    void addDiscountToProduct(Long productId, DiscountDTO discount);
    void addDiscountToGroupOfProductByProductName(String productName, DiscountDTO discount);
    void addDiscountToGroupOfProductByOrganization(Long organization, DiscountDTO discount);
    void updateDiscountToProduct(Long updatableId, DiscountDTO discount);
    void updateDiscountToGroupOfProductByProductName(String productName, DiscountDTO discount);
    void updateDiscountToGroupOfProductByOrganization(Long organization, DiscountDTO discount);
    void buyProduct(Long productId, Long userId);

}
