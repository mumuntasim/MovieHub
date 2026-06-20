package com.moviehub.web;

import com.moviehub.model.dto.user.UserRegisterDTO;
import com.moviehub.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userRegisterDTO", new UserRegisterDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO registerDTO) {
        userService.registerUser(registerDTO);
        return "redirect:/login";
    }
}