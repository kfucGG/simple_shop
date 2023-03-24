package com.example.adminservice.controllers;


import com.example.adminservice.dto.UserDTO;
import com.example.adminservice.feignClients.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminUserController {

    private final UserFeignClient userClient;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userClient.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable Long userId) {
        return userClient.getUserById(userId);
    }

    @DeleteMapping("{userId}/delete")
    public HttpStatus deleteUser(@PathVariable Long userId) {
        userClient.deleteUserById(userId);
        return HttpStatus.OK;
    }

    @PostMapping("/{userId}/addbalance")
    public HttpStatus addBalanceToUser(@PathVariable Long userId,
                                       @RequestParam("sum") Integer sum) {
        userClient.addMoneyToUserBalance(userId, sum);
        return HttpStatus.OK;
    }
}
