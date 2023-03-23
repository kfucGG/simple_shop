package ru.internet_shop.authenticationservice.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.internet_shop.authenticationservice.feignClients.UserClient;
import ru.internet_shop.authenticationservice.util.JwtUtil;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserClient userClient;

    @PostMapping("/registration")
    public String registration(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("email") String email) {
        String usernameOfSavedUser = userClient.registrateUser(username, password, email);
        return JwtUtil.generateToken(usernameOfSavedUser);
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {

        boolean isCorrect = userClient.isUsernameAndPasswordIsCorrect(username, password);
        if (!isCorrect)
            throw new RuntimeException("username or password not valid");

        return JwtUtil.generateToken(username);
    }
    @PostMapping("/validate")
    public Long validateToken(@RequestParam("token") String token) {
        return userClient.validateToken(JwtUtil.getUsernameClaimFromToken(token));
    }

    @PostMapping("/role")
    public String getRoleByToken(@RequestParam("token") String token) {
        String role = userClient.getRoleByUsername(JwtUtil.getUsernameClaimFromToken(token));
        return role;
    }
}
