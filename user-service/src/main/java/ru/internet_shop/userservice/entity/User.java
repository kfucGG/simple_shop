package ru.internet_shop.userservice.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.internet_shop.userservice.dto.UserLoginDTO;
import ru.internet_shop.userservice.dto.UserRegistrationDTO;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_sq")
    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer balance;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    public User(UserRegistrationDTO user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }
    public User(UserLoginDTO user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
}
