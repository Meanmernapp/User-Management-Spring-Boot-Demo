package com.usermanagementdemo.com.UserManagementDemoSpringBootApp.service.impl;

import com.usermanagementdemo.com.UserManagementDemoSpringBootApp.dto.entity.UserEntity;
import com.usermanagementdemo.com.UserManagementDemoSpringBootApp.dto.request.UserRequest;
import com.usermanagementdemo.com.UserManagementDemoSpringBootApp.dto.response.BaseResponse;
import com.usermanagementdemo.com.UserManagementDemoSpringBootApp.repository.UserRepository;
import com.usermanagementdemo.com.UserManagementDemoSpringBootApp.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public BaseResponse createUpdateUser(UserRequest userRequest, boolean add) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            if (add) {
                userRequest.setId(null);
                UserEntity userEntity = this.userRepository.findByEmail(userRequest.getEmail());
                if (userEntity != null) {
                    baseResponse.setResponseCode("200");
                    baseResponse.setResponseMessage("Email already exists");
                } else {
                    UserEntity userEntityStored = this.userRepository.saveAndFlush(new UserEntity(userRequest));
                    baseResponse.setResponseCode("200");
                    baseResponse.setResponseMessage(String.format("User created successfully with id %s", userEntityStored.getId()));
                }
            } else {
                if (userRequest.getId() != null) {
                    Optional<UserEntity> userEntity = this.userRepository.findById(userRequest.getId());
                    if (userEntity.isPresent()) {
                        UserEntity userEntityFound = this.userRepository.findByEmail(userRequest.getEmail());
                        if (userEntityFound != null && userEntityFound.getId().equals(userEntity.get().getId())) {
                            UserEntity userEntityUpdated = this.userRepository.saveAndFlush(new UserEntity(userRequest));
                            baseResponse.setResponseCode("200");
                            baseResponse.setResponseMessage(String.format("User updated successfully with id %s", userEntityUpdated.getId()));
                        } else if (userEntityFound == null){
                            UserEntity userEntityUpdated = this.userRepository.saveAndFlush(new UserEntity(userRequest));
                            baseResponse.setResponseCode("200");
                            baseResponse.setResponseMessage(String.format("User updated successfully with id %s", userEntityUpdated.getId()));
                        } else {
                            baseResponse.setResponseCode("200");
                            baseResponse.setResponseMessage("Email already exists");
                        }
                    } else {
                        baseResponse.setResponseCode("201");
                        baseResponse.setResponseMessage(String.format("User not found with id %s", userRequest.getId()));
                    }
                } else {
                    baseResponse.setResponseCode("1001");
                    baseResponse.setResponseMessage("User Id is required");
                }
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            baseResponse.setResponseCode("500");
            baseResponse.setResponseMessage("Error while creating or updating user. Please check logs");
        }
        return baseResponse;
    }

    @Override
    public BaseResponse readUser(Long userId) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            Optional<UserEntity> userEntity = this.userRepository.findById(userId);
            if (userEntity.isPresent()) {
                baseResponse.setResponseCode("00");
                baseResponse.setResponseMessage("Success");
                baseResponse.setData(userEntity.get());
            } else {
                baseResponse.setResponseCode("201");
                baseResponse.setResponseMessage(String.format("User not found against id %s", userId));
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            baseResponse.setResponseCode("500");
            baseResponse.setResponseMessage("Error while getting user. Please check logs");
        }
        return baseResponse;
    }

    @Override
    public BaseResponse listAllUsers() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<UserEntity> userEntities = this.userRepository.findAll();
            if (!userEntities.isEmpty()) {
                baseResponse.setResponseCode("00");
                baseResponse.setResponseMessage("Success");
                baseResponse.setData(userEntities);
            } else {
                baseResponse.setResponseCode("201");
                baseResponse.setResponseMessage("No Record");
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            baseResponse.setResponseCode("500");
            baseResponse.setResponseMessage("Error while getting users. Please check logs");
        }
        return baseResponse;
    }

    @Override
    public BaseResponse deleteUser(Long userId) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            Optional<UserEntity> userEntity = this.userRepository.findById(userId);
            if (userEntity.isPresent()) {
                this.userRepository.delete(userEntity.get());
                baseResponse.setResponseCode("00");
                baseResponse.setResponseMessage("User deleted successfully");
            } else {
                baseResponse.setResponseCode("201");
                baseResponse.setResponseMessage(String.format("User not found against id %s", userId));
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            baseResponse.setResponseCode("500");
            baseResponse.setResponseMessage("Error while getting user. Please check logs");
        }
        return baseResponse;
    }
}
