package com.back.domain.user.auth.controller;

import com.back.domain.user.auth.dto.FindByPassWordReq;
import com.back.domain.user.auth.dto.FindIdReq;
import com.back.domain.user.auth.dto.FindIdRes;
import com.back.domain.user.user.entity.User;
import com.back.domain.user.user.service.UserService;
import com.back.global.rsData.RsData;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("findId")
    @Operation(summary = "아이디 찾기")
    public RsData<FindIdRes> findId(@Valid @RequestBody FindIdReq findIdReq) {
        String inputEmail = findIdReq.getEmail();
        User user = userService.findByEmail(inputEmail).orElseThrow(() -> new ServiceException("존재하지 않는 회원입니다."));

        return new RsData<>("200-1", "회원님의 아이디는 %s 입니다.".formatted(user.getUsername()));
    }

    @PutMapping("updatePassword")
    @Operation(summary = "비밀번호 변경")
    public RsData<Void> updatePassword(@Valid @RequestBody FindByPassWordReq findByPassWordReq) {
        User user = userService.findByUsername(findByPassWordReq.getUsername()).orElseThrow(() -> new ServiceException("존재하지 않는 회원입니다."));

        if (!user.getEmail().equals(findByPassWordReq.getEmail())) {
            throw new ServiceException("이메일이 일치하지 않습니다.");
        }

        userService.updatePassword(user, findByPassWordReq.getNewPassword());

        return new RsData<>("200-1", "회원님의 비밀번호가 변경되었습니다.");
    }
}
