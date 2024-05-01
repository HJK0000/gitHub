package com.example.demo.domain;

public class User {
	
	private String id;
	private String pw;
	private int uno;
	
	public User(String id, String pw) {
		
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public int getUno() {
		return uno;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", uno=" + uno + "]";
	}
	
}
