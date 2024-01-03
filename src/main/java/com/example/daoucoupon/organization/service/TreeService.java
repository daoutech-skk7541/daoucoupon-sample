package com.example.daoucoupon.organization.service;

import com.example.daoucoupon.company.model.Company;
import com.example.daoucoupon.company.service.CompanyService;
import com.example.daoucoupon.organization.model.Node;
import com.example.daoucoupon.organization.model.Organization;
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

    public List<Node> getTreeInfoByCompanyId(Long companyId) {
        Company company = companyService.getCompanyById(companyId);
        List<Organization> organizations = organizationService.getOrganizationsByCompanyId(companyId);

        // 회사
        Node rootNode = Node.builder()
                .id("0").text(company.getCompanyName())
                .icon("fa fa-folder")
                .expanded(true)
                .build();

        // 조직
        Map<Optional<Long>, List<Organization>> organizationByParentId = organizations.stream()
                .collect(groupingBy(organization -> Optional.ofNullable(organization.getParentId())));

        List<Node> nodes = createTree(organizationByParentId, Optional.empty());
        rootNode.setNodes(nodes);

        return Collections.singletonList(rootNode);

    }

    private List<Node> createTree(Map<Optional<Long>, List<Organization>> organizationByParentId, Optional<Long> parentId) {
        List<Organization> organizations = organizationByParentId.get(parentId);
        if (organizations == null) {
            return null;
        }

        return organizations.stream().map(organization -> Node.builder()
                .id(organization.getId().toString())
                .text(organization.getOrganizationName())
                .nodes(createTree(organizationByParentId, Optional.of(organization.getId())))
                .build()).collect(Collectors.toList());
    }
}
