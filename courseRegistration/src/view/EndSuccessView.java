package view;

import java.util.ArrayList;
import java.util.Optional;

import model.dto.CourseRegistation;

public class EndSuccessView {
	
	//�������� Ư�� ������Ʈ ��� 
	public static void courseView(CourseRegistation course){
		
		Optional<Object> opt = Optional.ofNullable(course);
		System.out.println(opt.orElse("�ش� ������Ʈ�� �������� �ʽ��ϴ�."));
		
	}
	
	//�������� ��� ������Ʈ ���
	public static void courseListView(ArrayList<CourseRegistation> allCourse){
		
		Optional<Object> opt = Optional.ofNullable(allCourse);
		System.out.println(opt.orElse("�ش� ������ �������� �ʽ��ϴ�."));
		
	}
	
	//���� ���� ������ �ܼ� �޽����� ������ ȭ�鿡 ����ϴ� ��� 
	public static void successView(String message) {
		System.out.println(message);
		
	}
	
	
}
