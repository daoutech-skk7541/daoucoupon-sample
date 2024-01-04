package com.example.daoucoupon.user.service;

import com.example.daoucoupon.user.repository.UserRepository;
import com.example.daoucoupon.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public List<UserDto> getAllUsersByOrganizationId(Long organizationId) {
        return userRepository.getAllUsersByOrganizationId(organizationId);
    }
}
