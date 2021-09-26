package tempEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class course {

	@Column(name="course_id")
	private String course_id;
	
	@Column(name="course_name")
	private String course_name;
	
	@Column(name="proffesor_id")
	private int proffesor_id;
	
	public course(){
		
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getProffesor_id() {
		return proffesor_id;
	}

	public void setProffesor_id(int proffesor_id) {
		this.proffesor_id = proffesor_id;
	}

	@Override
	public String toString() {
		return "course [course_id=" + course_id + ", course_name=" + course_name + ", proffesor_id=" + proffesor_id
				+ "]";
	}
	
}
