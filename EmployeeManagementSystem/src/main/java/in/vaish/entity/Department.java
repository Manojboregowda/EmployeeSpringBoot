package in.vaish.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "depttab", uniqueConstraints = @UniqueConstraint(columnNames = { "dname" }))
@Entity
public class Department {

	@Id
	@Column(name = "did")
	private Integer did;

	@Column(name = "dname", unique = true)
	private String dname;

	@Column(name = "empdid")
	@OneToMany(mappedBy = "deptid", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Employee> employees;
}
