package com.thabng.trading.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thabng.trading.domian.User_Role;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

@Entity
@Data
public class User {
    //We are making this value a primary key
@Id
//We want the Id to be generated automatically using auto
@GeneratedValue(strategy = GenerationType.AUTO)
private Long Id;
private String FullName;
private String email;
//We use this annotation so that the password is not return back
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private String password;

//We gonna use 2 factor method use
    //The JPA annotation @Embedded is used to embed a type into another entity.
    //As a result, we have our entity User, embedding TwoAuthFactor and mapping to a single database table
   @Embedded
   private TwoFactorAuth twoFactorAuth= new TwoFactorAuth();
//Use enum to hold value choices and customer is a default role
private User_Role role = User_Role.ROLE_CUSTOMER;


}
