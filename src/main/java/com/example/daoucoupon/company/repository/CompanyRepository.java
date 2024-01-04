package com.example.daoucoupon.company.repository;

import com.example.daoucoupon.company.dto.CompanyDto;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository {
    CompanyDto getCompanyById(Long companyId);
}
