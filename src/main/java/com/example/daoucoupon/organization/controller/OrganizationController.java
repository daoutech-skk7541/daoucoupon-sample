package com.example.daoucoupon.organization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrganizationController {
    @GetMapping("/organization")
    public String organization() {
        return "organization";
    }
}
