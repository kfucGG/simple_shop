package ru.internet_shop.authenticationservice.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegistrationDTO {

    private String username;
    private String password;
    private String email;
}
