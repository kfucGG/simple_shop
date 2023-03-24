package ru.internet_shop.userservice.services;

import ru.internet_shop.userservice.dto.UserLoginDTO;
import ru.internet_shop.userservice.dto.UserRegistrationDTO;
import ru.internet_shop.userservice.entity.Role;
import ru.internet_shop.userservice.entity.User;

import java.util.List;

public interface UserService {


    List<User> findAll();

    User findById(Long id);
    User addUser(UserRegistrationDTO user);
    void deleteUserById(Long id);
    void decreaseBalance(Long userId, Integer sum);
    void addMoneyToBalance(Long id, Integer sum);

    boolean checkUsernameAndPasswordIsCorrect(UserLoginDTO user);
    Role findUserRoleByUsername(String username);
    Long userIsExists(String username);
}
