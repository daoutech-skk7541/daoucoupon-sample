package com.example.daoucoupon.organization.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class NodeDto {

    private String id;
    private String text;
    private boolean expanded;
    private String icon;
    private List<NodeDto> nodeDtos;
    @JsonProperty("class")
    private String className;
    private String href;
}