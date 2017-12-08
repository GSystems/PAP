package main.java.pap.rf.dao;

import main.java.pap.rf.PersistenceDAOBean;
import main.java.pap.rf.entity.SkillEntity;

public class SkillDAOBean extends PersistenceDAOBean<SkillEntity, Long> implements SkillDAO {

	@Override
	public void insertSkill(SkillEntity skill) {
		insert(skill);
	}

}
