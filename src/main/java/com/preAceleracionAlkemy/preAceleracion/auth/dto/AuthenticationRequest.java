package com.preAceleracionAlkemy.preAceleracion.auth.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {

    @Email(message = "Username must be an email")
    @NotNull
    @NotEmpty
    private String username;
    @Size(min = 4, message = "The password must contain at least 8 characters")
    @NotNull
    @NotEmpty
    private String password;

}
