package com.example.adminservice.feignClients;


import com.example.adminservice.dto.UserDTO;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("user-service")
public interface UserFeignClient {

    @GetMapping("/users")
    List<UserDTO> getAllUsers();

    @GetMapping("/users/{id}")
    UserDTO getUserById(@PathVariable("id") Long id);

    @DeleteMapping("/users/{id}/delete")
    void deleteUserById(@PathVariable Long id);

    @PostMapping("/users/{id}/addbalance")
    void addMoneyToUserBalance(@PathVariable("id") Long id,
                               @RequestParam("sum") Integer sum);
}
