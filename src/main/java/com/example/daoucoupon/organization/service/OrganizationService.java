package com.example.daoucoupon.organization.service;

import com.example.daoucoupon.mapper.OrganizationMapper;
import com.example.daoucoupon.organization.model.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService {
    private final OrganizationMapper organizationMapper;

    public List<Organization> getAllOrganizations() {
        return organizationMapper.getAllOrganization();
    }
    public List<Organization> getOrganizationsByCompanyId(Long companyId) {
        return organizationMapper.getOrganizationsByCompanyId(companyId);
    }

    public Organization getOrganizationById(Long organizationId) {
        return organizationMapper.getOrganizationById(organizationId);
    }
}
