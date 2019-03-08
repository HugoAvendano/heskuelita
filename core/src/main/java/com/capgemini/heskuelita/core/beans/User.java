package com.capgemini.heskuelita.core.beans;

import lombok.*;

import java.time.LocalDate;



/*GENERA GETTERS, SETTERS, CONSTRUCTOR CON TODOS LO ARGUMENTOS, HASHCODE, EQUALS*/
@Data
/*GENERA EL CONSTRUCTOR SIN ARGMUMENTOS*/
@NoArgsConstructor
public class User {

    private String userName;

    private String password;

    private String email;

    private LocalDate created;

    private LocalDate update;


}
