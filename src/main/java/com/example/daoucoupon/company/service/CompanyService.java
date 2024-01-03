package com.example.daoucoupon.company.service;

import com.example.daoucoupon.company.model.Company;
import com.example.daoucoupon.mapper.CompanyMapper;
import com.example.daoucoupon.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyMapper companyMapper;

    public Company getCompanyById(Long companyId) {
        return companyMapper.getCompanyById(companyId);
    }
}
