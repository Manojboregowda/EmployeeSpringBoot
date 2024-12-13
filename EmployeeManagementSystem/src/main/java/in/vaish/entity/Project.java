package in.vaish.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="project")
@Entity
public class Project {

	@Id
	@Column(name = "pid")
	private Integer pid;
	
	@Column(name="pname")
	private String pname;
	
	@ManyToMany(mappedBy = "pid")
	@JsonIgnore
	private List<Employee> employees;
}
