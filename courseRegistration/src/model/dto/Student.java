package model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Student {
	//�л�ID
	private int studentId;
	
	//����
	private String major;
	
	//�л��̸�
	private String studentName;
	
	//�ڵ�����ȣ
	private String phoneNumber;
	
	//������û����
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
		builder.append("�й� : ");
		builder.append(studentId);
		builder.append(", ���� :");
		builder.append(major);
		builder.append(", �л��̸�: ");
		builder.append(studentName);
		builder.append(", �л� ����ó : ");
		builder.append(phoneNumber);
		builder.append(", ������û ���� : ");
		builder.append(registrationCourse);
		return builder.toString();
	}
}
