package com.back.domain.user.user.entity;

import com.back.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class User extends BaseEntity {

    private String username;
    private String password;
    private String email;
    private String role;
}
