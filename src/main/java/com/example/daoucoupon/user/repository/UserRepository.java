package com.example.daoucoupon.user.repository;

import com.example.daoucoupon.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    List<UserDto> getAllUsers();
    List<UserDto> getAllUsersByOrganizationId(Long organizationId);
}
