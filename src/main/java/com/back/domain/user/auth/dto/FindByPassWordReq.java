package com.back.domain.user.auth.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class FindByPassWordReq {

    @Size(min = 3, max = 20)
    @NotBlank(message = "아이디는 필수 항목입니다.")
    private String username;

    @NotBlank(message = "이메일은 필수 항목입니다.")
    private String email;

    @Size(min = 8, max = 20)
    @NotBlank(message = "비밀번호는 필수 항목입니다.")
    private String newPassword;
}
