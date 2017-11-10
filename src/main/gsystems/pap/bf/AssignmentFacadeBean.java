package main.gsystems.pap.bf;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import main.gsystems.pap.bf.transformer.AssignmentTransformer;
import main.gsystems.pap.bfcl.AssignmentFacade;
import main.gsystems.pap.bfcl.dto.ProjectDTO;
import main.gsystems.pap.bfcl.dto.SkillDTO;
import main.gsystems.pap.bfcl.dto.StudentDTO;
import main.gsystems.pap.df.AssignmentRepo;

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
	public void insertSkill(String skillName) {
		repo.insertSkill(AssignmentTransformer.toSkillFromDTO(new SkillDTO(skillName)));
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

}
