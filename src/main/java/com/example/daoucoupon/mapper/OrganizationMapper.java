package com.example.daoucoupon.mapper;

import com.example.daoucoupon.organization.model.Organization;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationMapper {
    List<Organization> getAllOrganization();
    List<Organization> getOrganizationsByCompanyId(Long companyId);
    Organization getOrganizationById(Long organizationId);
}
