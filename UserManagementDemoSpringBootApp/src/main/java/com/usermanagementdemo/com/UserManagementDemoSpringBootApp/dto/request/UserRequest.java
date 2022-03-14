package com.usermanagementdemo.com.UserManagementDemoSpringBootApp.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UserRequest {

    private Long id;

    @NotBlank(message = "Name is required")
    @Length(max = 128, message = "Name must be composed of maximum 128 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email is required in this format : abc@xyz.com")
    @Length(max = 64, message = "Email must be composed of maximum 64 characters")
    private String email;

    @NotBlank(message = "Secret is required")
    @Length(max = 64, message = "Secret must be composed of maximum 64 characters")
    private String secret;

    @NotBlank(message = "Phone number is required")
    @Length(max = 13, message = "Secret must be composed of maximum 13 characters")
    private String phoneNumber;

    @NotBlank(message = "Password is required")
    @Length(max = 255, message = "Secret must be composed of maximum 255 characters")
    private String password;

    @NotNull(message = "User active status is required")
    private Boolean isActive;
}
