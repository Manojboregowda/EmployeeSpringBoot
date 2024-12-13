package in.vaish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.vaish.entity.Department;
import in.vaish.exception.CustomDuplicateEmailException;
import in.vaish.repo.DepartmentRepository;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired
	private DepartmentRepository drepo;
	
	@PostMapping("/add")
	public Department addDepartment(@RequestBody Department dept) {
		try {
			if(drepo.findDeptByName(dept.getDname()).isPresent()) {
				throw new CustomDuplicateEmailException("Departname: "+dept.getDname()+" already exists..Please provide uique Departname");
			}else {
				return drepo.save(dept);
			}
		} catch (CustomDuplicateEmailException e) {
			e.getMessage();
		}
		return null;
	}
}
