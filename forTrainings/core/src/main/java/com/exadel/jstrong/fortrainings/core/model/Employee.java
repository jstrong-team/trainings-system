package com.exadel.jstrong.fortrainings.core.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login", length = 25)
    private String login;

    @Column(name = "password", length = 25)
    private String password;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "mail", length = 50)
    private String mail;

    @Column(name = "phone", length = 50)
    private String phone;

    @Transient
    private String role;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "employee_role", joinColumns = {
            @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private List<Role> roles = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    private Token token;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    private List<TrainerFeedback> trainerFeedbacks;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "subscribe",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "training_id")})
    private List<Training> subscribeTrainings;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "employee_notice",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "notice_id")})
    private List<Notice> notices;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
//    private List<Subscribe> subscribes;

    public Employee() {
    }

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

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public List<TrainerFeedback> getTrainerFeedbacks() {
        return trainerFeedbacks;
    }

    public void setTrainerFeedbacks(List<TrainerFeedback> trainerFeedbacks) {
        this.trainerFeedbacks = trainerFeedbacks;
    }

    public List<Training> getSubscribeTrainings() {
        return subscribeTrainings;
    }

    public void setSubscribeTrainings(List<Training> subscribeTrainings) {
        this.subscribeTrainings = subscribeTrainings;
    }

    public List<Notice> getNotices() {
        return notices;
    }

    public void setNotices(List<Notice> notices) {
        this.notices = notices;
    }

}
