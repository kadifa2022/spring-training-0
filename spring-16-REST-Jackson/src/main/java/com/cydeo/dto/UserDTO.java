package com.cydeo.dto;

import com.cydeo.enums.UserRole;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;
    //cant send password to ui side
    private String username;
    private UserRole role;
    @JsonManagedReference//this field is going to be  serialized
    private AccountDTO account;

}
