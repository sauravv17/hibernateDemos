package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Enrolment_Id", nullable=false)
	private String enrolmentId;
	
	@Column(name="Student_Name" , nullable=false)
	private String name;
	
	


	public Student() {
		
	}
	
	public Student(String enrolmentId, String name) {
		this.enrolmentId = enrolmentId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", enrolmentId=" + enrolmentId + ", name=" + name + "]";
	}
	
	
	
}
