package org.example.springweb.userdomain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDto {
    private String userId;
    private String password;
}
