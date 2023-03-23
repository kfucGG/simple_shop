package com.example.productservice.entity;

import com.example.productservice.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    private String organization;

    @Column(name = "product_price")
    private Integer productPrice;

    private Integer amount;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "discount_id", referencedColumnName = "id")
    private Discount productDiscount;

    @OneToMany(mappedBy = "product")
    private List<Grade> grades;
    @OneToMany(mappedBy = "product")
    private List<Review> personReviews;

    public Product(ProductDTO productDTO) {
        this.productName = productDTO.getProductName();
        this.productPrice = productDTO.getProductPrice();
        this.productDescription = productDTO.getProductDescription();
        this.amount = productDTO.getAmount();
        this.organization = productDTO.getOrganization();
    }
    public Product(String productName, String productDescription, String organization, Integer productPrice, Integer amount) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.organization = organization;
        this.productPrice = productPrice;
        this.amount = amount;
    }
}
