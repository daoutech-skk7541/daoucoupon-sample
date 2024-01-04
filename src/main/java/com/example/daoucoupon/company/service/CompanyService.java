package com.example.daoucoupon.company.service;

import com.example.daoucoupon.company.dto.CompanyDto;
import com.example.daoucoupon.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyDto getCompanyById(Long companyId) {
        return companyRepository.getCompanyById(companyId);
    }
}
