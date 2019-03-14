package com.capgemini.heskuelita.core.beans;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table (name = "Student")
public class Student {

    @Id
    @Column(name = "stu_id")
    @GeneratedValue(strategy = GenerationType.AUTO,generator="seq_stud")
    @SequenceGenerator(name="seq_stud", sequenceName="seq_stud")

    private int id;

    @Column(name = "stu_name" , nullable = false)
    private String name;

    @Column(name = "stu_lastname", nullable = false)
    private String lastname;

    @Column(name = "stud_birthdate" , nullable = false)
    private LocalDate birthdate;

    @Column(name = "stu_docType", nullable = false)
    private String docType;


    @Column(name = "stu_identification", nullable = false)
    private long identification;

    @Column(name = "stu_gender", nullable = false)
    private String gender;


    public Student() {

    }

    public Student(int id, String name, String lastname, LocalDate birthdate, String docType,long identifiaction , String gender, User user) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.docType = docType;
        this.identification = identifiaction;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
