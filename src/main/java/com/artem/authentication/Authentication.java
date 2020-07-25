package com.artem.authentication;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Authentication {

    private final String username;
    private final String password;

    private static Authentication authentication = null;

    private Authentication(String username, String password){
        this.username = username;
        this.password = password;
    }

    public static void createInstance(String username, String password){
        if(authentication==null) {
            authentication = new Authentication(username, password);
        } else{
            throw new IllegalArgumentException();
        }
    }

    public static Authentication getInstance(){
        return authentication;
    }


    public static void clear(){
        authentication = null;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("username", username)
                .append("password", password)
                .toString();
    }
}
