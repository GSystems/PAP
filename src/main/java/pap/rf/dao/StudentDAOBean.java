package main.java.pap.rf.dao;

import java.util.List;

import javax.persistence.TypedQuery;

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

	@Override
	public List<StudentEntity> findByEmail(String email) {
		List<StudentEntity> resultList;
		TypedQuery<StudentEntity> query = getEntityManager().createNamedQuery(StudentEntity.FIND_BY_EMAIL,
				StudentEntity.class);
		query.setParameter("email", "%" + email + "%");
		resultList = query.getResultList();
		return resultList;
	}

}
