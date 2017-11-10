package main.gsystems.pap.rf.dao;

import main.gsystems.pap.rf.BaseDAOBean;
import main.gsystems.pap.rf.entity.StudentEntity;

public class StudentDAOBean extends BaseDAOBean<StudentEntity, Long> implements StudentDAO {

	@Override
	public void insertStudent(StudentEntity student) {
		insert(student);
	}

	@Override
	public StudentEntity findByStudentId(long studentId) {
		return findById(studentId);
	}

	@Override
	public void updateStudent(StudentEntity student) {
		update(student);
	}

}
