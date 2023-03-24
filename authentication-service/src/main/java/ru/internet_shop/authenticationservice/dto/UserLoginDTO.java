package ru.internet_shop.authenticationservice.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginDTO {

    private String username;
    private String password;
}
