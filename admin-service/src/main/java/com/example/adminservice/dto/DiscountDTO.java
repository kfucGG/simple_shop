package com.example.adminservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DiscountDTO {

    private Integer percent;
    private LocalDate startOfDiscount;
    private LocalDate endOfDiscount;
}