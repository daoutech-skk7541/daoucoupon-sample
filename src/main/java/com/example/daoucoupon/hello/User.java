package com.example.daoucoupon.hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
public class User {
    private Long organizationId;
    private String username;
    private String email;
    private LocalDateTime createdAt;

    public User(Long organizationId, String username, String email, LocalDateTime createdAt) {
        this.organizationId = organizationId;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
    }
}