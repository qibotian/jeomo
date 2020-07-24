package com.jeomo.auth.domain;

import java.util.Set;

public class User {

    private String username;
    private String password;
    private Set<String> prorities;

    public User(String username, String password, Set<String> prorities) {
        this.username = username;
        this.password = password;
        this.prorities = prorities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getProrities() {
        return prorities;
    }

    public void setProrities(Set<String> prorities) {
        this.prorities = prorities;
    }
}
