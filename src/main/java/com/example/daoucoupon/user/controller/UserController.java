package com.example.daoucoupon.user.controller;

import com.example.daoucoupon.user.dto.UserDto;
import com.example.daoucoupon.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user-data/{organizationId}")
    public List<UserDto> getUserData(@PathVariable Long organizationId) {
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
    public List<UserDto> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/api/users/{organizationId}")
    public List<UserDto> getUsersByOrganizationId(@PathVariable(name = "organizationId") Long organizationId) {
        return userService.getAllUsersByOrganizationId(organizationId);
    }
}
