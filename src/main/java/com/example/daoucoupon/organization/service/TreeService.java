package com.example.daoucoupon.organization.service;

import com.example.daoucoupon.company.dto.CompanyDto;
import com.example.daoucoupon.company.service.CompanyService;
import com.example.daoucoupon.organization.dto.NodeDto;
import com.example.daoucoupon.organization.dto.OrganizationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class TreeService {
    private final OrganizationService organizationService;
    private final CompanyService companyService;

    public List<NodeDto> getTreeInfoByCompanyId(Long companyId) {
        CompanyDto companyDto = companyService.getCompanyById(companyId);
        List<OrganizationDto> organizationDtos = organizationService.getOrganizationsByCompanyId(companyId);

        // 회사
        NodeDto rootNodeDto = NodeDto.builder()
                .id("0").text(companyDto.getCompanyName())
                .icon("fa fa-folder")
                .expanded(true)
                .build();

        // 조직
        Map<Optional<Long>, List<OrganizationDto>> organizationByParentId = organizationDtos.stream()
                .collect(groupingBy(organizationDto -> Optional.ofNullable(organizationDto.getParentId())));

        List<NodeDto> nodeDtos = createTree(organizationByParentId, Optional.empty());
        rootNodeDto.setNodes(nodeDtos);

        return Collections.singletonList(rootNodeDto);

    }

    private List<NodeDto> createTree(Map<Optional<Long>, List<OrganizationDto>> organizationByParentId, Optional<Long> parentId) {
        List<OrganizationDto> organizationDtos = organizationByParentId.get(parentId);
        if (organizationDtos == null) {
            return null;
        }

        return organizationDtos.stream().map(organizationDto -> NodeDto.builder()
                .id(organizationDto.getId().toString())
                .text(organizationDto.getOrganizationName())
                .nodes(createTree(organizationByParentId, Optional.of(organizationDto.getId())))
                .build()).collect(Collectors.toList());
    }
}
