package com.example.daoucoupon.organization.repository;

import com.example.daoucoupon.organization.dto.OrganizationDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository {
    List<OrganizationDto> getOrganizationsByCompanyId(Long companyId);
}
