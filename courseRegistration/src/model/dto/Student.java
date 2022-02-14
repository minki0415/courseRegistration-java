package model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Student {
	//학생ID
	private int studentId;
	
	//전공
	private String major;
	
	//학생이름
	private String studentName;
	
	//핸드폰번호
	private String phoneNumber;
	
	//수강신청과목
	private String registrationCourse;
	
	public Student() {}
	public Student(int studentId, String major, String studentName, String phoneNumber,String registrationCourse) {
		super();
		this.studentId = studentId;
		this.major = major;
		this.studentName = studentName;
		this.phoneNumber = phoneNumber;
		this.registrationCourse = registrationCourse;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("학번 : ");
		builder.append(studentId);
		builder.append(", 전공 :");
		builder.append(major);
		builder.append(", 학생이름: ");
		builder.append(studentName);
		builder.append(", 학생 연락처 : ");
		builder.append(phoneNumber);
		builder.append(", 수강신청 과목 : ");
		builder.append(registrationCourse);
		return builder.toString();
	}
}
