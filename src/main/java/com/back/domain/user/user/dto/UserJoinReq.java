package com.back.domain.user.user.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@ToString
@Data
public class UserJoinReq {
    @Size(min = 3, max = 20)
    @NotBlank(message = "아이디는 필수 항목입니다.")
    private String username;

    @Size(min = 8, max = 20)
    @NotBlank(message = "비밀번호는 필수 항목입니다.")
    private String password;

    @Size(min = 2, max = 20)
    @NotBlank
    private String nickname;

    @NotBlank(message = "이메일은 필수 항목입니다.")
    private String email;
}
