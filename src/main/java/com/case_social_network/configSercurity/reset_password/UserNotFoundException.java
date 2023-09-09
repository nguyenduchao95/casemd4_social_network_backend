package com.case_social_network.configSercurity.reset_password;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String message){
        super(message);
    }
}
