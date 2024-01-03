package com.example.daoucoupon.company.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Company {
    private Long id;
    private String companyName;
    private LocalDateTime createdAt;
}
