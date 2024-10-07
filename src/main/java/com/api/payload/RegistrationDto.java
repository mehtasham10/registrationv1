package com.api.payload;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto {

    @Size(min = 2,message = "min letter should be 2")
    private String name;

    @Email
    private String email;

    @Size(min = 10,max = 10, message = "min and max digits should be 10")
    private String mobile;

}