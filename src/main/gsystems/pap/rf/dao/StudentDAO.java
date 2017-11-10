package main.gsystems.pap.rf.dao;

import main.gsystems.pap.rf.BaseDAO;
import main.gsystems.pap.rf.entity.StudentEntity;

public interface StudentDAO extends BaseDAO<StudentEntity, Long> {

	/**
	 * Add a student
	 * 
	 * @param student
	 */
	void insertStudent(StudentEntity student);

	/**
	 * Find a student by id
	 * 
	 * @param studentId
	 * @return
	 */
	StudentEntity findByStudentId(long studentId);

	/**
	 * Edit a student
	 * 
	 * @param student
	 */
	void updateStudent(StudentEntity student);
}
