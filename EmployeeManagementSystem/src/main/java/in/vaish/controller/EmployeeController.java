package in.vaish.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.vaish.entity.Employee;
import in.vaish.exception.CustomDuplicateEmailException;
import in.vaish.exception.DepartmentNotFoundException;
import in.vaish.exception.EmployeeNotFoundException;
import in.vaish.repo.EmployeeRepository;
import in.vaish.service.EmployeeService;
import in.vaish.serviceimpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/empapi")
public class EmployeeController {

	@Autowired
	public EmployeeRepository erepo;
	
	@Autowired
	public EmployeeService service;
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee emp) {
		if(erepo.findByEmail(emp.getEmail()).isPresent()) {
			throw new CustomDuplicateEmailException("Email: "+emp.getEmail()+" already exists..Please use different email.");
		}else {
			return erepo.save(emp);
		}
	}
	
	@GetMapping("/{id}")
	public Employee getEmpById(@PathVariable Integer id) {
		Employee emp = erepo.getEmployee(id);
		if(emp!=null) {
			return emp;
		}else {
			throw new EmployeeNotFoundException("Employee with id: "+id+" not found..Please provide valid employee");
		}
	}
	
	@PutMapping("update/{id}")
	public Employee updateEmployeeById(@PathVariable Integer id,@RequestBody Employee emp) {
		Employee conemp = erepo.findById(id).get();
		if(conemp!=null) {
			conemp.setEmail(emp.getEmail());
			conemp.setEname(emp.getEname());
			return erepo.save(conemp);
		}else {
			throw new EmployeeNotFoundException("Employee with id: "+id+" is not present. Please provide a vaild employee id");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		Employee emp = erepo.findById(id).get();
		try {
			if(emp!=null && emp.getEid()==id) {
				erepo.deleteById(id);
				return "Employee with id: "+id+" is successfully deleted";
			}else {
				throw new EmployeeNotFoundException("Employee with id: "+id+" is not present. Please provide a vaild employee id to delete");
			}
		} catch (EmployeeNotFoundException e) {
			return e.getMessage();
		}
	}
	
	@GetMapping("/dept/{id}")
	public List<Employee> getAllEmpByDeptId(@PathVariable Integer  id){
		List<Employee> listEmp = service.getEmpByDptId(id);
		if(!listEmp.isEmpty()) {
			return listEmp;
		}else {
			throw new DepartmentNotFoundException("Not found Employees with department id: "+id+" select other department id");
		}
	}
}
