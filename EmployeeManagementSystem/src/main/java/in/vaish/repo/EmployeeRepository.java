package in.vaish.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.vaish.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
		
	@Query("FROM Employee e WHERE e.email= :email")
	public Optional<Employee> findByEmail(String email);
	
	@Query("SELECT e FROM Employee e JOIN FETCH e.deptid WHERE e.id = :id")
	public Employee getEmployee(@Param("id") Integer id);
	
	@Query("SELECT e FROM Employee e JOIN e.deptid d WHERE d.did = :id")
	public List<Employee> getAllEmpByDeptId(@Param("id") Integer id);
	
}
