package com.example.daoucoupon.user.service;

import com.example.daoucoupon.mapper.UserMapper;
import com.example.daoucoupon.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;


    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public List<User> getAllUsersByOrganizationId(Long organizationId) {
        return userMapper.getAllUsersByOrganizationId(organizationId);
    }
}
