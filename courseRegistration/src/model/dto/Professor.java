package model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Professor {
	//�����̸�
	private String professorName;
	
	//�к�
	private String department;
	
	//���� �̸���
	private String professorEmail;
	
	//�����
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
		builder.append("������ : ");
		builder.append(professorName);
		builder.append(", ���μ� : ");
		builder.append(department);
		builder.append(", ���� �̸��� : ");
		builder.append(professorEmail);
		builder.append(", ����� : ");
		builder.append(courseName);
		return builder.toString();
	}
	
	
}
