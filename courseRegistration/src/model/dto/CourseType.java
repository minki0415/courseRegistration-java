package model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CourseType {
	//�����
	private String courseType;
	
	//Ŀ��ŧ��
	private String curriculum;
	
	//Ŀ��ŧ�� �󼼳���
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
		builder.append("���� Ÿ�� : ");
		builder.append(courseType);
		builder.append(", Ŀ��ŧ�� : ");
		builder.append(curriculum);
		builder.append(", Ŀ��ŧ�� �� : ");
		builder.append(curriculumDetail);
		return builder.toString();
	}
}
