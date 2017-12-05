package main.java.pap.df.model;

import java.util.List;

public class Student {

	private Integer id;
	private String firstname;
	private String lastname;
	private String email;

	private String skills;
	private List<Project> preferences;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public List<Project> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<Project> preferences) {
		this.preferences = preferences;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
}
