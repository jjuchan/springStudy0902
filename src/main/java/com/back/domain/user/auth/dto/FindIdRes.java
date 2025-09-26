package com.back.domain.user.auth.dto;

public record FindIdRes(
        String username
) {
    public FindIdRes(String username) {
        this.username = username;
    }
}
