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
	
	@ManyToOne(cascade= {CascadeType.PERSIST , CascadeType.REMOVE})
	@JoinColumn(name="guide_id")
	private Guide guide;
	
	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	public Student() {
		
	}
	
	public Student(String enrolmentId, String name, Guide guide) {
		this.enrolmentId = enrolmentId;
		this.name = name;
		this.guide=guide;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", enrolmentId=" + enrolmentId + ", name=" + name + ", guide=" + guide + "]";
	}
	
	
	
}
