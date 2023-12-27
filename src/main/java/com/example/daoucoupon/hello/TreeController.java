package com.example.daoucoupon.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class TreeController {

    @GetMapping("/tree-data")
    public List<Node> getTreeData() {
        return getCustomData();
    }

    private List<Node> getCustomData() {
        return Collections.singletonList(
                Node.builder()
                        .id("0")
                        .text("다우기술")
                        .icon("fa fa-folder")
                        .expanded(true)
                        .nodes(Arrays.asList(
                                Node.builder()
                                        .id("1")
                                        .text("SW 개발본부")
                                        .expanded(false)
                                        .icon("fa fa-folder")
                                        .nodes(Arrays.asList(
                                                Node.builder()
                                                        .id("2")
                                                        .text("비즈웹개발팀")
                                                        .icon("fa fa-folder")
                                                        .build(),
                                                Node.builder()
                                                        .id("3")
                                                        .text("비즈플랫폼팀")
                                                        .icon("fa fa-folder")
                                                        .build(),
                                                Node.builder()
                                                        .id("4")
                                                        .text("플랫폼서비스팀")
                                                        .icon("fa fa-folder")
                                                        .build(),
                                                Node.builder()
                                                        .id("5")
                                                        .text("경영서비스개발팀")
                                                        .icon("fa fa-folder")
                                                        .build(),
                                                Node.builder()
                                                        .id("6")
                                                        .text("모바일개발팀")
                                                        .icon("fa fa-folder")
                                                        .build(),
                                                Node.builder()
                                                        .id("7")
                                                        .text("그룹웨어개발팀")
                                                        .icon("fa fa-folder")
                                                        .build()
                                        ))
                                        .build(),
                                Node.builder()
                                        .id("8")
                                        .text("서비스개발본부")
                                        .expanded(false)
                                        .icon("fa fa-folder")
                                        .build()
                        ))
                        .build());
    }
}
