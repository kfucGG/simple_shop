package ru.internet_shop.userservice.init;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.internet_shop.userservice.entity.User;
import ru.internet_shop.userservice.repositories.UserRepository;
import ru.internet_shop.userservice.services.RoleService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserInitializer {


    private final RoleService roleService;
    private final UserRepository userRepository;

    @PostConstruct
    @Transactional
    public void initTestUsers() {
        User user = new User();
        User admin = new User();

        user.setRole(roleService.addRoleToUser("ROLE_USER"));
        user.setEmail("user@mail.ru");
        user.setBalance(0);
        user.setUsername("user");
        user.setPassword("user");

        admin.setRole(roleService.addRoleToUser("ROLE_ADMIN"));
        admin.setEmail("admin@mail.ru");
        admin.setBalance(0);
        admin.setUsername("admin");
        admin.setPassword("admin");

        userRepository.saveAll(List.of(user, admin));
    }
}
