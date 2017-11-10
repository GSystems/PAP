package main.gsystems.pap.rf.dao;

import main.gsystems.pap.rf.BaseDAO;
import main.gsystems.pap.rf.entity.SkillEntity;

public interface SkillDAO extends BaseDAO<SkillEntity, Long> {

	/**
	 * Add a skill
	 * 
	 * @param skill
	 */
	void insertSkill(SkillEntity skill);

	/**
	 * Find a skill by id
	 * 
	 * @param skillId
	 * @return
	 */
	SkillEntity findBySkillId(long skillId);
}
