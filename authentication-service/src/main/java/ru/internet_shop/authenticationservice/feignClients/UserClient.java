package ru.internet_shop.authenticationservice.feignClients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@FeignClient("user-service")
public interface UserClient {

    @PostMapping("/users/add")
    String registrateUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("email") String email);

    @PostMapping("/users/check")
    boolean isUsernameAndPasswordIsCorrect(@RequestParam("username") String username,
                                           @RequestParam("password") String password);
    @PostMapping("/users/validate")
    Long validateToken(@RequestParam("username") String username);

    @PostMapping("/users/role")
    String getRoleByUsername(@RequestParam("username") String username);
}
