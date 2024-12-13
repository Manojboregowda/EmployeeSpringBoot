package in.vaish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.vaish.entity.Employee;
import in.vaish.repo.EmployeeRepository;

public interface EmployeeService{
	
	public List<Employee> getEmpByDptId(Integer id);
}
