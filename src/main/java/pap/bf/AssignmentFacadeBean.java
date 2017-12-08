package main.java.pap.bf;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import main.java.pap.bf.transformer.AssignmentTransformer;
import main.java.pap.bfcl.AssignmentFacade;
import main.java.pap.bfcl.dto.ProjectDTO;
import main.java.pap.bfcl.dto.SkillDTO;
import main.java.pap.bfcl.dto.StudentDTO;
import main.java.pap.df.AssignmentRepo;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AssignmentFacadeBean implements AssignmentFacade {

	@Inject
	private AssignmentRepo repo;

	@Override
	public void insertStudent(StudentDTO student) {
		repo.insertStudent(AssignmentTransformer.toStudentFromDTO(student));
	}

	@Override
	public void insertProject(ProjectDTO project) {
		repo.insertProject(AssignmentTransformer.toProjectFromDTO(project));
	}

	@Override
	public void updateProject(ProjectDTO project) {
		repo.updateProject(AssignmentTransformer.toProjectFromDTO(project));
	}

	@Override
	public void updateStudent(StudentDTO student) {
		repo.updateStudent(AssignmentTransformer.toStudentFromDTO(student));
	}

	@Override
	public List<StudentDTO> findAllStudents() {
		return AssignmentTransformer.fromStudentListToDTO(repo.findAllStudents());
	}

	@Override
	public List<ProjectDTO> findAllProjects() {
		return AssignmentTransformer.fromProjectListToDTO(repo.findAllProjects());
	}

	@Override
	public List<StudentDTO> findStudentsByEmail(String email) {
		return AssignmentTransformer.fromStudentListToDTO(repo.findStudentsByEmail(email));
	}

	@Override
	public void insertSkill(SkillDTO skill) {
		repo.insertSkill(AssignmentTransformer.toSkillFromDTO(skill));
	}

}
