package in.vaish.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.vaish.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	@Query("FROM Department d WHERE d.dname= :dname ")
	public Optional<Department> findDeptByName(String dname);
}
