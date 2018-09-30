package ru.neustupov.restvotingwithspringbootandreact.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequest {

    @Getter
    @Setter
    @NotBlank
    @Size(min = 4, max = 40)
    private String name;

    @Getter
    @Setter
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @Getter
    @Setter
    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
}
