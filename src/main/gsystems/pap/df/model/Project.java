package main.gsystems.pap.df.model;

import java.util.List;

public class Project {

	private Integer id;
	private String name;
	private Integer capacity;
	private String coordinator;

	private String skills;
	private List<Student> preferences;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(String coordinator) {
		this.coordinator = coordinator;
	}

	public List<Student> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<Student> preferences) {
		this.preferences = preferences;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

}
