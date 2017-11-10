package main.gsystems.pap.rf.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import main.gsystems.pap.util.GeneralConstants;

@Entity
@Table(schema = GeneralConstants.SCHEMA, name = "skill")
@NamedQuery(name = "SkillEntity.findAll", query = SkillEntity.FIND_ALL)
public class SkillEntity {

	public static final String FIND_ALL = "SELECT name FROM SkillEntity";

	public SkillEntity() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	public SkillEntity(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
