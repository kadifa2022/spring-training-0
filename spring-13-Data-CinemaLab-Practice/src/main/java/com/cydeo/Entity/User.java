package com.cydeo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name="user_account")
public class User extends BaseEntity {

    private String email;
    private String password;
    private String username;
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="account_details_id")//@JoinColumn to change name
    private Account account;
}
