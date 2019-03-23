package com.capgemini.heskuelita.core.beans;


import java.time.LocalDate;

import javax.persistence.*;

@Entity (name = "Student") 
@Table (name = "student")
public class Student {

    @Id
    @Column(name = "id_student")
    @GeneratedValue(strategy = GenerationType.AUTO,generator="seq_student")
    @SequenceGenerator(name="seq_student", sequenceName="seq_student")
    private int id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastname;
    
    /*
    @Column(name = "birthdate" , nullable = true)
    private LocalDate birthdate;
	*/
    
    @Column(name = "documentation_type", nullable = false)
    private String docType;


    @Column(name = "identification", nullable = false)
    private long identification;

   
    @Column(name = "gender", nullable = false)
    private String gender;
   
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "id_user" )
    private User user;
	
    public Student() {
    }
    

    public Student(int id, String name, String lastname, String docType,long identifiaction , String gender, User user) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        //this.birthdate = birthdate;
        this.docType = docType;
        this.identification = identifiaction;
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
    /*
    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
	*/
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

  	
    public User getUser() {
		return user;
	}

	
    public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "id_student= " + id + ", name=" + name + ", lastname=" + lastname 
				+ ", docType=" + docType + ", identification=" + identification
				+ ", gender=" + gender + ", user="
				+ user;
	}
    
    

}

    
