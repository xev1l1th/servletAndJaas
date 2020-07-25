package com.artem.authentication;

import javax.security.auth.Subject;
import java.io.Serializable;
import java.security.Principal;
import java.util.Objects;

public class SimplePrinciple implements Principal, Serializable {

    private final String name;
    public SimplePrinciple(final String name) {
        if(name == null){
            throw new NullPointerException("illegal null");
        }
        this.name = name;
    }

    @Override
    public boolean implies(Subject subject) {
        return subject.getPrincipals().contains(this);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimplePrinciple that = (SimplePrinciple) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

