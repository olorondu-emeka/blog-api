package com.emeka.blogspringboot.models;

public class ResponseUser {
    String jwt;

    public ResponseUser(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
