package ru.internet_shop.userservice.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.internet_shop.userservice.dto.UserDTO;
import ru.internet_shop.userservice.entity.User;
import ru.internet_shop.userservice.services.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.findAll()
                .stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") Long id) {
        return new UserDTO(userService.findById(id));
    }

    @DeleteMapping("/{id}/delete")
    public HttpStatus deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return HttpStatus.OK;
    }

    @PostMapping("/{id}/addbalance")
    public HttpStatus addBalanceToUser(@PathVariable("id") Long id,
                                       @RequestParam("sum") Integer sum) {
        userService.addMoneyToBalance(id, sum);
        return HttpStatus.OK;
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("email") String email) {
        User user = userService.addUser(username, password, email);
        return user.getUsername();
    }

    @PostMapping("/check")
    public boolean checkIfUsernameExists(@RequestParam("username") String username,
                                         @RequestParam("password") String password) {
        return userService.checkUsernameAndPasswordIsCorrect(username, password);
    }
    @PostMapping("/role")
    public String getUserRoleByUsername(@RequestParam("username") String username) {
        return userService.findUserRoleByUsername(username).getRoleName();
    }
    @PostMapping("/validate")
    public Long validateUsername(@RequestParam("username") String username) {
        return userService.userIsExists(username);
    }
}
