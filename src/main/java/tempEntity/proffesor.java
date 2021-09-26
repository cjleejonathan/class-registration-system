package tempEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="proffesor")
public class proffesor {

	@Column(name="proffesor_id")
	private int proffesor_id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="course_id")
	private String course_id;
	
	public proffesor() {
		
	}

	public int getProffesor_id() {
		return proffesor_id;
	}

	public void setProffesor_id(int proffesor_id) {
		this.proffesor_id = proffesor_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	@Override
	public String toString() {
		return "proffesor [proffesor_id=" + proffesor_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", course_id=" + course_id + "]";
	}
	
	
}
