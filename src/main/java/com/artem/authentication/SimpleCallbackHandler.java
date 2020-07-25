package com.artem.authentication;

import javax.security.auth.callback.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class SimpleCallbackHandler implements CallbackHandler, Serializable {

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        Authentication authentication = Authentication.getInstance();
        NameCallback nameCallback = (NameCallback) callbacks[0];
        PasswordCallback passwordCallback = (PasswordCallback) callbacks[1];
        nameCallback.setName(authentication.getUsername());
        passwordCallback.setPassword(authentication.getPassword().toCharArray());
    }
}
