package com.capgemini.heskuelita.beens;

public class User {
	
	private String email;
	private String pasword;

		//builder
	
	public User() {
		
	}
	public User(int id_Usuario, String email, String pasword) {
		this.email = email;
		this.pasword = pasword;
	}
	
	//Getters and Setters

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	
	
	
	
}