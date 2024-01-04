package com.example.daoucoupon.company.repository;

import com.example.daoucoupon.company.dto.CompanyDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface CompanyRepository {
    CompanyDto getCompanyById(Long companyId);
}
