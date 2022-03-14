package com.usermanagementdemo.com.UserManagementDemoSpringBootApp.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {

    private String responseCode;
    private String responseMessage;

    private Object data;
}
