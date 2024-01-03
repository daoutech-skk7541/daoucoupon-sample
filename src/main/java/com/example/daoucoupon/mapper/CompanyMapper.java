package com.example.daoucoupon.mapper;

import com.example.daoucoupon.company.model.Company;
import com.example.daoucoupon.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyMapper {
    Company getCompanyById(Long companyId);
}
