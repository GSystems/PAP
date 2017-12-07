package main.java.pap.rf.dao;

import java.util.List;

import main.java.pap.rf.BaseDAO;
import main.java.pap.rf.entity.StudentEntity;

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

	/**
	 * Retrieve all students
	 * 
	 * @return
	 */
	List<StudentEntity> findAllStudents();

	/**
	 * Retrieve students by email
	 * 
	 * @param name
	 * @return
	 */
	List<StudentEntity> findByEmail(String email);

}
