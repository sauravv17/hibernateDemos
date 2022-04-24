package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Guide {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="StaffId" , nullable =false)
	private String staffId;
	private String name;
	private Integer Salary;
	
	@OneToMany(mappedBy="guide", cascade= {CascadeType.PERSIST , CascadeType.REMOVE})
	private List<Student> students =new ArrayList<Student>();
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Guide() {
		
	}
	
	public Guide(String staffId, String name, Integer salary) {
		this.staffId = staffId;
		this.setName(name);
		Salary = salary;
	}

	@Override
	public String toString() {
		return "Guide [id=" + id + ", staffId=" + staffId + ", name=" + getName() + ", Salary=" + Salary + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
