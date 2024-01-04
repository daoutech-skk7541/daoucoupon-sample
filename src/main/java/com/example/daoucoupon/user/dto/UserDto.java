package com.example.daoucoupon.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class UserDto {
    private Long id;
    private Long organizationId;
    private String username;
    private String email;
    private LocalDateTime createdAt;

    public UserDto(Long id, Long organizationId, String username, String email, LocalDateTime createdAt) {
        this.id = id;
        this.organizationId = organizationId;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
    }
}