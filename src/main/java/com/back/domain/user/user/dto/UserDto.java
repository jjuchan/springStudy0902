package com.back.domain.user.user.dto;

import com.back.domain.user.user.entity.User;

import java.time.LocalDateTime;

public record UserDto(
        long id,
        LocalDateTime createDate,
        LocalDateTime modifyDate,
        String nickname,
        String email
) {

    public UserDto(User user) {
        this(
                user.getId(),
                user.getCreateDate(),
                user.getModifyDate(),
                user.getNickname(),
                user.getEmail()
        );
    }
}
