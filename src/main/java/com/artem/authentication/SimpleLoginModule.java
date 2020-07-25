package com.artem.authentication;

import com.artem.domain.User;

import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SimpleLoginModule implements LoginModule, Serializable {
    private static final List<User> listUsers = Arrays.asList(new User("xev1l", "123"), new User("therealyou", "123"));
    private Subject subject;
    private SimplePrinciple simplePrinciple;
    private CallbackHandler callbackHandler;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> map, Map<String, ?> map1) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;

    }

    @Override
    public boolean login() throws LoginException {
        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("User Name:");
        callbacks[1] = new PasswordCallback("Password:", false);
        User user = null;
        try {
            callbackHandler.handle(callbacks);
            String name = ((NameCallback) callbacks[0]).getName();
            String password = new String(((PasswordCallback) callbacks[1]).getPassword());
            user = new User(name, password);
            if(listUsers.contains(user)){
                simplePrinciple = new SimplePrinciple(user.getName());
                System.out.println("authentication success");
                return true;
            } else{
                System.out.println("authentication not success");
                Authentication.clear();
            }
        } catch (IOException | UnsupportedCallbackException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean commit() throws LoginException {
        System.out.println("commit");
        boolean f = false;
        if(subject!=null && !subject.getPrincipals().contains(simplePrinciple)){
            subject.getPrincipals().add(simplePrinciple);
            f = true;
        }
        return f;
    }

    @Override
    public boolean abort() throws LoginException {
        if(subject!=null && simplePrinciple!=null && subject.getPrincipals().contains(simplePrinciple)){
            subject.getPrincipals().remove(simplePrinciple);
        }
        subject = null;
        simplePrinciple = null;
        Authentication.clear();
        return true;
    }

    @Override
    public boolean logout() throws LoginException {
        subject.getPrincipals().remove(simplePrinciple);
        subject = null;
        Authentication.clear();
        return true;
    }
}

