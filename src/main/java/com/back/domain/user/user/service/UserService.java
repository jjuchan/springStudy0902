package com.back.domain.user.user.service;

import com.back.domain.user.user.entity.Role;
import com.back.domain.user.user.entity.User;
import com.back.domain.user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User join(String username, String password, String nickname, String email) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new ServiceException("이미 존재하는 회원입니다.");
        }
        password = passwordEncoder.encode(password);

        User user = new User(username, password, nickname, email);

        user.getRoles().add(Role.GENERAL);
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
