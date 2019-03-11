package com.capgemini.heskuelita.core.beans;

import lombok.*;

import java.time.LocalDate;



/*GENERA GETTERS, SETTERS, CONSTRUCTOR CON TODOS LO ARGUMENTOS, HASHCODE, EQUALS*/
//@Data
/*GENERA EL CONSTRUCTOR SIN ARGMUMENTOS*/
//@NoArgsConstructor
public class User {

    private String name;

    private String lastname;

    private String email;

    private String password;


    private String secQuestion;

    private String secAnswer;



    public User() {

    }

    public User(String name,String lastname, String email, String password, String secQuestion, String secAnswer) {

        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.secQuestion = secQuestion;
        this.secAnswer = secAnswer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecQuestion() {
        return secQuestion;
    }

    public void setSecQuestion(String secQestion) {
        this.secQuestion = secQestion;
    }

    public String getSecAnswer() {
        return secAnswer;
    }

    public void setSecAnswer(String secAnswer) {
        this.secAnswer = secAnswer;
    }
}
