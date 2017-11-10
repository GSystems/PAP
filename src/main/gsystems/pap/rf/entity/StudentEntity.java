package main.gsystems.pap.rf.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import main.gsystems.pap.util.GeneralConstants;

@Entity
@Table(schema = GeneralConstants.SCHEMA, name = "student")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="student_skill",
		joinColumns = @JoinColumn(name = "id_student", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "id_skill", referencedColumnName = "id"))
	private List<SkillEntity> skills;

	@ManyToMany
	@JoinTable(name="student_preferences",
		joinColumns = @JoinColumn(name="id_project", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "id_student", referencedColumnName = "id"))
	private List<ProjectEntity> preferences;

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

	public List<SkillEntity> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillEntity> skills) {
		this.skills = skills;
	}

	public List<ProjectEntity> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<ProjectEntity> preferences) {
		this.preferences = preferences;
	}

}
