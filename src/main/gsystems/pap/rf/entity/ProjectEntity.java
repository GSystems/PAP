package main.gsystems.pap.rf.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import main.gsystems.pap.util.GeneralConstants;

@Entity
@Table(schema = GeneralConstants.SCHEMA, name = "project")
public class ProjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer capacity;
	private String coordinator;
	private String skills;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = StudentEntity.class)
	@JoinTable(name = "project_preferences",
		joinColumns = @JoinColumn(name="id_student", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "id_project", referencedColumnName = "id"))
	private List<StudentEntity> preferences;

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

	public List<StudentEntity> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<StudentEntity> preferences) {
		this.preferences = preferences;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

}
