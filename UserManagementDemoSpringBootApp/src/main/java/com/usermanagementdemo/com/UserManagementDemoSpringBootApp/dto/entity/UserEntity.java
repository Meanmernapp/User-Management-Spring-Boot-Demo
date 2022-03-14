package com.usermanagementdemo.com.UserManagementDemoSpringBootApp.dto.entity;

import com.usermanagementdemo.com.UserManagementDemoSpringBootApp.dto.request.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Users")
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_EMAIL", unique = true)
    private String email;

    @Column(name = "USER_SECRET")
    private String secret;

    @Column(name = "USER_PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "USER_PASSWORD")
    private String password;

    @Column(name = "USER_IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "USER_CREATED_AT")
    private Date createdAt;

    public UserEntity(UserRequest userRequest) {
        this.id = userRequest.getId();
        this.name = userRequest.getName();
        this.email = userRequest.getEmail();
        this.secret = userRequest.getSecret();
        this.phoneNumber = userRequest.getPhoneNumber();
        this.password = userRequest.getPassword();
        this.isActive = userRequest.getIsActive();
        this.createdAt = new Date();
    }
}
