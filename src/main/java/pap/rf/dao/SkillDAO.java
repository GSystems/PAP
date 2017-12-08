package main.java.pap.rf.dao;

import main.java.pap.rf.PersistenceDAO;
import main.java.pap.rf.entity.SkillEntity;

public interface SkillDAO extends PersistenceDAO<SkillEntity, Long> {

	/**
	 * Add a new skill
	 * 
	 * @param skill
	 */
	void insertSkill(SkillEntity skill);

}
