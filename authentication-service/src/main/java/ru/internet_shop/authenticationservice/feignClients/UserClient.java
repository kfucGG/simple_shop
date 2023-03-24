package ru.internet_shop.authenticationservice.feignClients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.internet_shop.authenticationservice.dto.UserLoginDTO;
import ru.internet_shop.authenticationservice.dto.UserRegistrationDTO;

import java.util.HashMap;

@FeignClient("user-service")
public interface UserClient {

    @PostMapping("/users/add")
    String registrateUser(@RequestBody UserRegistrationDTO user);

    @PostMapping("/users/check")
    boolean isUsernameAndPasswordIsCorrect(@RequestBody UserLoginDTO user);
    @PostMapping("/users/validate")
    Long validateToken(@RequestParam("username") String username);

    @PostMapping("/users/role")
    String getRoleByUsername(@RequestParam("username") String username);
}
