package view;

import java.util.ArrayList;
import java.util.Optional;

import model.dto.CourseRegistation;

public class EndSuccessView {
	
	//진행중인 특정 프로젝트 출력 
	public static void courseView(CourseRegistation course){
		
		Optional<Object> opt = Optional.ofNullable(course);
		System.out.println(opt.orElse("해당 프로젝트는 존재하지 않습니다."));
		
	}
	
	//진행중인 모든 프로젝트 출력
	public static void courseListView(ArrayList<CourseRegistation> allCourse){
		
		Optional<Object> opt = Optional.ofNullable(allCourse);
		System.out.println(opt.orElse("해당 과목은 존재하지 않습니다."));
		
	}
	
	//서비스 로직 성공시 단순 메시지를 브라우저 화면에 출력하는 기능 
	public static void successView(String message) {
		System.out.println(message);
		
	}
	
	
}
