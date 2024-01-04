package com.example.daoucoupon.user.repository;

import com.example.daoucoupon.user.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    List<UserDto> getAllUsers();
    List<UserDto> getAllUsersByOrganizationId(Long organizationId);
}
