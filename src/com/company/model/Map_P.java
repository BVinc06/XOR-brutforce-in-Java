package com.company.model;

public class Map_P {
    private String login;
    private String password;

    /**** GETTERS AND SETTERS *****/
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /******************************/

    public String selectIDbyLoginPassword(String login, String password) {
        return "SELECT * FROM personne WHERE login = '" + login + "' AND Password = '" + password + "'";
    }
}
