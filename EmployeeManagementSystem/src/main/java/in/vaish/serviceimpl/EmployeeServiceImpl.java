package in.vaish.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import in.vaish.entity.Employee;
import in.vaish.repo.EmployeeRepository;
import in.vaish.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	public EmployeeRepository erepo;

	@Override
	public List<Employee> getEmpByDptId(Integer id) {
		return erepo.getAllEmpByDeptId(id);
	}
}
