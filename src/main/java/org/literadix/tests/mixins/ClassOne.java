package org.literadix.tests.mixins;


public class ClassOne implements InterfaceOne {

    private String password;
    
    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String helloOne() {
        return "hello from one";
    }
}
