package com.back.domain.user.user.controller;

import com.back.domain.user.user.dto.JoinForm;
import com.back.domain.user.user.dto.LoginForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

    @GetMapping("/login")
    public String loginPage(LoginForm loginForm) {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/login";
        }

        return "redirect:/post/list";
    }

    @GetMapping("/join")
    public String joinPage(JoinForm joinForm) {

        return "user/join";
    }

    @PostMapping("/join")
    public String join(@Valid JoinForm joinForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/join";
        }
        if (!joinForm.getPassword1().equals(joinForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordnotmatch", "비밀번호가 일치하지 않습니다.");
            return "user/join";
        }
        return "redirect:/post/list";
    }
}
