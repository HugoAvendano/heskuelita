package com.capgemini.heskuelita.core.beans;

import lombok.*;
import javax.persistence.*;



//GENERA GETTERS, SETTERS, CONSTRUCTOR CON TODOS LO ARGUMENTOS, HASHCODE, EQUALS*/
//@Data
//GENERA EL CONSTRUCTOR SIN ARGMUMENTOS
//@NoArgsConstructor*/

@Entity	(name="User")
@Table (name = "users")
public class User {

    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO,generator="seq_users")
    @SequenceGenerator(name="seq_users", sequenceName="seq_users")
    private int id_user;
    
    @Column (name = "email", length = 48, nullable = false)
    private String email;


    @Column (name = "password", length = 12, nullable = false)
    private String password;

    @Column (name = "question", length = 48, nullable = false)
    private String secQuestion;

    @Column (name = "answer", length = 60, nullable = false)
    private String secAnswer;

    public User() {

    }
    
    
    public User(int id_user, String email, String password, String secQuestion, String secAnswer){
    	this.id_user = id_user;
        this.email = email;
        this.password = password;
        this.secQuestion = secQuestion;
        this.secAnswer = secAnswer;
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
