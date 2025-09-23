package com.back.domain.user.user.controller;

import com.back.domain.user.user.dto.UserDto;
import com.back.domain.user.user.dto.UserJoinReq;
import com.back.domain.user.user.entity.User;
import com.back.domain.user.user.service.UserService;
import com.back.global.rsData.RsData;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @Operation(summary = "내 정보")
    @Transactional(readOnly = true)
    @GetMapping("/me/{id}")
    public RsData<UserDto> me(@PathVariable Long id) {
        User user = userService.findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));

        return new RsData<>(
                "200-1",
                "%s 님 정보입니다.".formatted(user.getNickname()),
                new UserDto(user)
        );
    }


    @PostMapping
    public RsData<UserDto> join(@Valid @RequestBody UserJoinReq userJoinReq) {
         User user = userService.join(userJoinReq.getUsername(),userJoinReq.getPassword(),userJoinReq.getNickname(),userJoinReq.getEmail());
        return new RsData<>(
                "200-1",
                "%s 님 환영합니다.".formatted(user.getUsername()),
                new UserDto(user)
        );
    }
}
