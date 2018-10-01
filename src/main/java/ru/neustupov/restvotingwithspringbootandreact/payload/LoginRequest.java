package ru.neustupov.restvotingwithspringbootandreact.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    @NotBlank
    private String nameOrEmail;

    @NotBlank
    private String password;
}
