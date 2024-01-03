package com.example.daoucoupon.organization.controller;

import com.example.daoucoupon.organization.model.Node;
import com.example.daoucoupon.organization.service.TreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TreeController {

    private final TreeService treeService;

    @GetMapping("/api/tree/{companyId}")
    public List<Node> getTreeInfo(@PathVariable(name = "companyId") Long companyId) {
        return treeService.getTreeInfoByCompanyId(companyId);
    }
}
