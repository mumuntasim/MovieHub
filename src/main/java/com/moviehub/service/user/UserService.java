package com.moviehub.service.user;

import com.moviehub.model.dto.user.UserRegisterDTO;
import com.moviehub.model.entity.user.User;
import com.moviehub.model.entity.user.UserRole;
import com.moviehub.repository.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserRegisterDTO registerDTO) {


        User user = User.builder()
                .username(registerDTO.getUsername())
                .email(registerDTO.getEmail())
                .firstName(registerDTO.getFirstName())
                .lastName(registerDTO.getLastName())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .role(UserRole.USER)
                .build();

        userRepository.save(user);
    }


}