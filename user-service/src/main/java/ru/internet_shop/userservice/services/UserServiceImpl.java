package ru.internet_shop.userservice.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public User addUser(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setBalance(0);
        user.setRole(roleService.addRoleToUser("ROLE_USER"));
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addMoneyToBalance(Long id, Integer sum) {
        User user = findById(id);
        user.setBalance(user.getBalance() + sum);
    }

    @Override
    public boolean checkUsernameAndPasswordIsCorrect(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("username does not exists"));
        return user.getPassword().equals(password);
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
