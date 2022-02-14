package model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Professor {
	//교수이름
	private String professorName;
	
	//학부
	private String department;
	
	//교수 이메일
	private String professorEmail;
	
	//과목명
	private String courseName;
	
	public Professor() {}
	public Professor(String professorName, String department, String professorEmail, String courseName) {
		super();
		this.professorName = professorName;
		this.department = department;
		this.professorEmail = professorEmail;
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("교수명 : ");
		builder.append(professorName);
		builder.append(", 담당부서 : ");
		builder.append(department);
		builder.append(", 교수 이메일 : ");
		builder.append(professorEmail);
		builder.append(", 과목명 : ");
		builder.append(courseName);
		return builder.toString();
	}
	
	
}
