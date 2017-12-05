package main.java.pap.rf.dao;

import java.util.List;

import main.java.pap.rf.BaseDAOBean;
import main.java.pap.rf.entity.StudentEntity;

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

	@Override
	public List<StudentEntity> findAllStudents() {
		return findAll();
	}

}
