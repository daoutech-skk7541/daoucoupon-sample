package com.example.daoucoupon.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class UserController {

    @GetMapping("/user-data/{organizationId}")
    public List<User> getUserData(@PathVariable Long organizationId) {
        return getCustomData(organizationId);
    }

    private List<User> getCustomData(Long organizationId) {
        List<User> defaultUsers = Arrays.asList(
                new User(organizationId, "John Doe", "john.doe@example.com", LocalDateTime.now()),
                new User(organizationId, "Jane Doe", "jane.doe@example.com", LocalDateTime.now()),
                new User(organizationId, "Bob Smith", "bob.smith@example.com", LocalDateTime.now())
        );

        // 단순 추가 유저 생성 (organizationId는 동일하게 설정)
        List<User> additionalUsersList = IntStream.range(0, organizationId.intValue())
                .mapToObj(index -> new User(organizationId, "Additional User " + index, "additionalUser" + index + "@example.com", LocalDateTime.now()))
                .toList();

        // 기본 유저와 추가 유저를 합쳐서 최종 결과를 반환
        List<User> finalUserList = new ArrayList<>(defaultUsers);
        finalUserList.addAll(additionalUsersList);

        return finalUserList;
    }
}
