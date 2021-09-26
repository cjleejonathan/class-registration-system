package tempEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="rigister")
public class rigister {
	
	@Column(name="course_id")
	private String course_id;
	
	@Column(name="student_id")
	private int student_id;
	
	public rigister() {
		
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	@Override
	public String toString() {
		return "rigister [course_id=" + course_id + ", student_id=" + student_id + "]";
	}
	
	
}
