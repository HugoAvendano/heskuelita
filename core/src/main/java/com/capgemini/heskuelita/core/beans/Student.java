package com.capgemini.heskuelita.core.beans;

import java.time.LocalDate;

public class Student {

    private int id;
    private String name;
    private String lastname;
    private LocalDate birthdate;
    private String docType;
    private long identification;
    private String phone;
    private String gender;
    private User user;

    public Student() {

    }

    public Student(int id, String name, String lastname, LocalDate birthdate, String docType,long identifiaction ,String phone, String gender, User user) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.docType = docType;
        this.identification = identifiaction;
        this.phone = phone;
        this.gender = gender;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public void setIdentification(long identification) {
        this.identification = identification;
    }

    public long getIdentification() {
        return identification;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
