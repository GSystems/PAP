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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	private String skills;

	@Fetch(FetchMode.SELECT)
	@OneToMany (fetch = FetchType.EAGER)
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

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public List<ProjectEntity> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<ProjectEntity> preferences) {
		this.preferences = preferences;
	}

}
