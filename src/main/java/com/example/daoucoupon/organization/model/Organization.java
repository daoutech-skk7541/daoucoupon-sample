package com.example.daoucoupon.organization.model;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    private Long id;
    private String organizationName;
    private Long parentId;
    private Long companyId;
    private LocalDateTime createdAt;
}