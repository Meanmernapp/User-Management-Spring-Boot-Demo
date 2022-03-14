package com.usermanagementdemo.com.UserManagementDemoSpringBootApp.controller;

import com.usermanagementdemo.com.UserManagementDemoSpringBootApp.dto.request.UserRequest;
import com.usermanagementdemo.com.UserManagementDemoSpringBootApp.dto.response.BaseResponse;
import com.usermanagementdemo.com.UserManagementDemoSpringBootApp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserRequest userRequest) {
        BaseResponse baseResponse = this.userService.createUpdateUser(userRequest, true);
        if (baseResponse.getResponseCode().equals("500")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(baseResponse);
        } else {
            return ResponseEntity.status(HttpStatus.OK.value()).body(baseResponse);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateUser(@RequestBody @Valid UserRequest userRequest) {
        BaseResponse baseResponse = this.userService.createUpdateUser(userRequest, false);
        if (baseResponse.getResponseCode().equals("500")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(baseResponse);
        } else {
            return ResponseEntity.status(HttpStatus.OK.value()).body(baseResponse);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<Object> readUser(@RequestParam @NotNull(message = "User id is required") Long id) {
        BaseResponse baseResponse = this.userService.readUser(id);
        if (baseResponse.getResponseCode().equals("500")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(baseResponse);
        } else {
            return ResponseEntity.status(HttpStatus.OK.value()).body(baseResponse);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteUser(@RequestParam @NotNull(message = "User id is required") Long id) {
        BaseResponse baseResponse = this.userService.deleteUser(id);
        if (baseResponse.getResponseCode().equals("500")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(baseResponse);
        } else {
            return ResponseEntity.status(HttpStatus.OK.value()).body(baseResponse);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Object> listAllUsers() {
        BaseResponse baseResponse = this.userService.listAllUsers();
        if (baseResponse.getResponseCode().equals("500")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(baseResponse);
        } else {
            return ResponseEntity.status(HttpStatus.OK.value()).body(baseResponse);
        }
    }
}
