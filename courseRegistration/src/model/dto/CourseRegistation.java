package model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CourseRegistation {
	
	//강의명, 강의 고유이름
	private String courseName;
	
	//교수
	private Professor courseProfessor;
	
	//학생(수강생)
	private Student courseStudent;
	
	//강의종류
	private CourseType courseType;
	
	//수강가능한 전공
	private String coursePossibleMajor;
	
	//개강일
	private String startDate;
	
	//종강일
	private String endDate;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("과목명 : ");
		builder.append(courseName);
		builder.append(", 교수 : ");
		builder.append(courseProfessor);
		builder.append(", 학생 :");
		builder.append(courseStudent);
		builder.append(", 과목타입 : ");
		builder.append(courseType);
		builder.append(", 수강신청가능한 학과 : ");
		builder.append(coursePossibleMajor);
		builder.append(", 개강일 : ");
		builder.append(startDate);
		builder.append(", 종강일 : ");
		builder.append(endDate);
		return builder.toString();
	}
	
}
