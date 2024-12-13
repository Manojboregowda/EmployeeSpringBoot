package in.vaish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.vaish.entity.Project;
import in.vaish.exception.CustomDuplicateEmailException;
import in.vaish.repo.ProjectRepository;

@RestController
@RequestMapping("/poj")
public class ProjectController {

	@Autowired
	public ProjectRepository preop;

	@PostMapping("/add")
	public Project addProject(@RequestBody Project project) {

		if (preop.findById(project.getPid()).isPresent()) {
			throw new CustomDuplicateEmailException("Project Id: " + project.getPid() + " already exists...");
		} else {
			return preop.save(project);
		}

	}
}
