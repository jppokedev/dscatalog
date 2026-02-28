package com.bitworld.dscatalog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDTO {

    @NotBlank(message = "Campo obrigatorio")
    @Email(message = "Email invalido")
    private String email;

    public EmailDTO(){}

    public EmailDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
