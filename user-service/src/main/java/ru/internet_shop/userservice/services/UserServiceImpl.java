package ru.internet_shop.userservice.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.internet_shop.userservice.dto.UserLoginDTO;
import ru.internet_shop.userservice.dto.UserRegistrationDTO;
import ru.internet_shop.userservice.entity.Role;
import ru.internet_shop.userservice.entity.User;
import ru.internet_shop.userservice.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }

    @Transactional
    @Override
    public User addUser(UserRegistrationDTO user) {
        User newUser = new User(user);
        newUser.setBalance(0);
        newUser.setRole(roleService.addRoleToUser("ROLE_USER"));
        return userRepository.save(newUser);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void decreaseBalance(Long userId, Integer sum) {
        User user = findById(userId);
        user.setBalance(user.getBalance() - sum);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void addMoneyToBalance(Long id, Integer sum) {
        User user = findById(id);
        user.setBalance(user.getBalance() + sum);
    }

    @Override
    public boolean checkUsernameAndPasswordIsCorrect(UserLoginDTO loginUser) {
        User user = userRepository.findByUsername(loginUser.getUsername())
                .orElseThrow(() -> new RuntimeException("username does not exists"));
        return user.getPassword().equals(loginUser.getPassword());
    }

    @Override
    public Role findUserRoleByUsername(String username) {
        return userRepository.findByUsername(username).get().getRole();
    }

    @Override
    public Long userIsExists(String username) {
         Optional<User> user = userRepository.findByUsername(username);
         if (user.isEmpty())
             throw new RuntimeException("user with such username does not exists");

         return user.get().getId();
    }
}
