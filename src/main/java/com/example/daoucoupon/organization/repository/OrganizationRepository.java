package com.example.daoucoupon.organization.repository;

import com.example.daoucoupon.organization.dto.OrganizationDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrganizationRepository {
    List<OrganizationDto> getOrganizationsByCompanyId(Long companyId);
}
