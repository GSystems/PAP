package main.gsystems.pap.rf.dao;

import main.gsystems.pap.rf.BaseDAOBean;
import main.gsystems.pap.rf.entity.SkillEntity;

public class SkillDAOBean extends BaseDAOBean<SkillEntity, Long> implements SkillDAO {

	@Override
	public void insertSkill(SkillEntity skill) {
		insert(skill);
	}

	@Override
	public SkillEntity findBySkillId(long skillId) {
		return findById(skillId);
	}

}
