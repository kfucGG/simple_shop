package ru.internet_shop.authenticationservice.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.internet_shop.authenticationservice.dto.UserLoginDTO;
import ru.internet_shop.authenticationservice.dto.UserRegistrationDTO;
import ru.internet_shop.authenticationservice.entity.JwtResponse;
import ru.internet_shop.authenticationservice.feignClients.UserClient;
import ru.internet_shop.authenticationservice.util.JwtUtil;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserClient userClient;

    @PostMapping("/registration")
    public JwtResponse registration(@RequestBody UserRegistrationDTO user) {
        String usernameOfSavedUser = userClient.registrateUser(user);
        return new JwtResponse(JwtUtil.generateToken(usernameOfSavedUser));
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody UserLoginDTO user) {

        boolean isCorrect = userClient.isUsernameAndPasswordIsCorrect(user);
        if (!isCorrect)
            throw new RuntimeException("username or password not valid");

        return new JwtResponse(JwtUtil.generateToken(user.getUsername()));
    }
    @PostMapping("/validate")
    public Long validateToken(@RequestParam("token") String token) {
        return userClient.validateToken(JwtUtil.getUsernameClaimFromToken(token));
    }

    @GetMapping("/role")
    public String getRoleByToken(@RequestParam("token") String token) {
        String role = userClient.getRoleByUsername(JwtUtil.getUsernameClaimFromToken(token));
        return role;
    }
}
