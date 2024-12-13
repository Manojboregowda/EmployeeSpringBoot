package in.vaish.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vaish.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
	
}
