package com.example.daoucoupon.mapper;

import com.example.daoucoupon.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> getAllUsers();
    List<User> getAllUsersByOrganizationId(Long organizationId);
}
