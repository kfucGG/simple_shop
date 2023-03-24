package com.example.productservice.feignClients;


import com.example.productservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient("user-service")
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    UserDTO getUser(@PathVariable("id") Long id);

    @PostMapping("/users/{id}")
    HttpStatus decreaseBalance(@RequestParam("sum") Integer sum,
                               @PathVariable("id") Long id);
}
