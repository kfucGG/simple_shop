package ru.internet_shop.userservice.services;

import ru.internet_shop.userservice.entity.Role;
import ru.internet_shop.userservice.entity.User;

import java.util.List;

public interface UserService {


    List<User> findAll();

    User findById(Long id);
    User addUser(String username, String password, String email);
    void deleteUserById(Long id);

    void addMoneyToBalance(Long id, Integer sum);

    boolean checkUsernameAndPasswordIsCorrect(String username, String password);
    Role findUserRoleByUsername(String username);
    Long userIsExists(String username);
}
