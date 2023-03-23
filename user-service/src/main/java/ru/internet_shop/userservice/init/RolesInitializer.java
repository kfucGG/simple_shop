package ru.internet_shop.userservice.init;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.internet_shop.userservice.entity.Role;
import ru.internet_shop.userservice.repositories.RoleRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RolesInitializer {

    private final RoleRepository roleRepository;

    @PostConstruct
    public void rolesInit() {
        Role role = new Role();
        role.setRoleName("ROLE_ADMIN");

        Role role2 = new Role();
        role.setRoleName("ROLE_USER");

        roleRepository.saveAll(List.of(role, role2));
    }
}
