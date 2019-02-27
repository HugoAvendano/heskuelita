package com.capgemini.heskuelita.beans;
import java.time.LocalDate;

public abstract class Person extends IDGenerator{
	
	public String name;
	public LocalDate birthday;
	public String email;
	public char sex;
	
	public Person() {
		super();
	}
	
	public Person(String name, LocalDate birthday, String email, char sex, int id) {
		this.id=id;
		this.name=name;
		this.birthday=birthday;
		this.email=email;
		this.sex=sex;
	}
	
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return name;
	}
}