package com.cydeo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {//we are customized JSON output with responseWrapper class
    //we will see in API
    private boolean success;
    private String message;
    private Integer code;
    private Object data; // can be any dto

    public ResponseWrapper(String message, Object data){//constructor
        this.message=message;
        this.data=data;
        this.code= HttpStatus.OK.value();
        this.success=true;

    }
    public ResponseWrapper(String message){// why we create two constructors?
        // if we delete something we can see data

        this.message=message;
        this.code=HttpStatus.OK.value();
        this.success=true;
    }




}
