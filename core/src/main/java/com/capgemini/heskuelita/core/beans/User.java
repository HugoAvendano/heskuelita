package com.capgemini.heskuelita.core.beans;

import lombok.*;
import javax.persistence.*;



/*GENERA GETTERS, SETTERS, CONSTRUCTOR CON TODOS LO ARGUMENTOS, HASHCODE, EQUALS*/
//@Data
/*GENERA EL CONSTRUCTOR SIN ARGMUMENTOS*/
//@NoArgsConstructor

@Entity
@Table (name = "User")
public class User {

    @Id
    @Column(name = "user_email", length = 48, nullable = false)
    private String email;


    @Column (name = "user_password", length = 12, nullable = false)
    private String password;

    @Column (name = "user_secQuestion", length = 48, nullable = false)
    private String secQuestion;

    @Column (name = "user_secQuestion", length = 60, nullable = false)
    private String secAnswer;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Student student;


    public User() {

    }

    public User( String email, String password, String secQuestion, String secAnswer, Student student) {

        this.email = email;
        this.password = password;
        this.secQuestion = secQuestion;
        this.secAnswer = secAnswer;
        this.student = student;
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

    public Student getStudent(){
        return student;
    }

    public void setStudent(Student student){
        this.student=student;
    }
}
