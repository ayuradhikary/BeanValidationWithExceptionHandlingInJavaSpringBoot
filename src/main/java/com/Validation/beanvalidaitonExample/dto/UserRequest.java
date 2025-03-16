package com.Validation.beanvalidaitonExample.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "username should not be null")
    private String name;
    @Email(message = "invalid email address")
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank //not empty and not null
    private String nationality;

}
