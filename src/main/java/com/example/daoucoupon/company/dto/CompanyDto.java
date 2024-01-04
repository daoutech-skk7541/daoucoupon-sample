package com.example.daoucoupon.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class CompanyDto {
    private Long id;
    private String companyName;
    private LocalDateTime createdAt;
}
