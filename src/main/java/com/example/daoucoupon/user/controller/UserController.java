package com.example.daoucoupon.user.controller;

import com.example.daoucoupon.user.model.User;
import com.example.daoucoupon.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user-data/{organizationId}")
    public List<User> getUserData(@PathVariable Long organizationId) {
        return userService.getAllUsersByOrganizationId(organizationId);
    }

//    private List<User> getCustomData(Long organizationId) {
//
//        return Arrays.asList(
//                new User((long) 1, organizationId, "John Doe", "john.doe@example.com", LocalDateTime.now()),
//                new User((long) 2, organizationId, "Jane Doe", "jane.doe@example.com", LocalDateTime.now()),
//                new User((long) 3, organizationId, "Bob Smith", "bob.smith@example.com", LocalDateTime.now())
//        );
//    }

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/api/users/{organizationId}")
    public List<User> getUsersByOrganizationId(@PathVariable(name = "organizationId") Long organizationId) {
        return userService.getAllUsersByOrganizationId(organizationId);
    }
}
