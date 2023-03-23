package ru.internet_shop.userservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.internet_shop.userservice.entity.Role;
import ru.internet_shop.userservice.entity.User;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {


    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer balance;
    private String role;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.balance = user.getBalance();
        this.role = user.getRole().getRoleName();
    }
}
