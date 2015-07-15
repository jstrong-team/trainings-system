package com.exadel.jstrong.fortrainings.core.model;

public class Employee {
    private int id;
    private String login;
    private String password;
    private String name;
    private String mail;
    private String phone;
    private String role;

    public Employee(int id, String login, String password,
                    String name, String mail, String phone,
                    String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.role = role;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
