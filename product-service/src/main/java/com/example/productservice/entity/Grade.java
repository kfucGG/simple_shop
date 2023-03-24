package com.example.productservice.entity;

import com.example.productservice.dto.GradeDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Grade {

    @Id
    @GeneratedValue(generator = "grade_seq")
    @SequenceGenerator(name = "grade_seq", sequenceName = "grade_seq")
    private Long id;

    private Integer grade;

    private Long userId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public Grade(Integer grade, Long userId, Product product) {
        this.grade = grade;
        this.userId = userId;
        this.product = product;
    }
}