package model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CourseType {
	//과목명
	private String courseType;
	
	//커리큘럼
	private String curriculum;
	
	//커리큘럼 상세내용
	private String curriculumDetail;
	
	public CourseType() {}
	public CourseType(String courseType, String curriculum, String curriculumDetail) {
		super();
		this.courseType = courseType;
		this.curriculum = curriculum;
		this.curriculumDetail = curriculumDetail;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("강의 타입 : ");
		builder.append(courseType);
		builder.append(", 커리큘럼 : ");
		builder.append(curriculum);
		builder.append(", 커리큘럼 상세 : ");
		builder.append(curriculumDetail);
		return builder.toString();
	}
}
