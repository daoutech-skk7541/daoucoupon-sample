package com.example.daoucoupon.organization.service;

import com.example.daoucoupon.organization.dto.OrganizationDto;
import com.example.daoucoupon.organization.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public List<OrganizationDto> getOrganizationsByCompanyId(Long companyId) {
        return organizationRepository.getOrganizationsByCompanyId(companyId);
    }
}
