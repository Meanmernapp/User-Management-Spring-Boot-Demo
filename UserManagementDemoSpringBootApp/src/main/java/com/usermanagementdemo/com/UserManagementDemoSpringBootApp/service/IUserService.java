package com.usermanagementdemo.com.UserManagementDemoSpringBootApp.service;

import com.usermanagementdemo.com.UserManagementDemoSpringBootApp.dto.request.UserRequest;
import com.usermanagementdemo.com.UserManagementDemoSpringBootApp.dto.response.BaseResponse;

public interface IUserService {

    BaseResponse createUpdateUser(UserRequest userRequest, boolean add);
    BaseResponse readUser(Long userId);
    BaseResponse listAllUsers();
    BaseResponse deleteUser(Long userId);
}
