package controller;

import java.util.Optional;

import exception.CourseNameDuplicationException;
import exception.CourseNotFoundException;
import exception.MajorNotFoundException;
import model.dto.CourseRegistation;
import model.dto.Professor;
import model.dto.Student;
import service.CourseRegistationService;
import view.EndFailView;
import view.EndSuccessView;

public class CourseRegistationController {
	
		private  static CourseRegistationController instance = new CourseRegistationController();
		
		private CourseRegistationService service = CourseRegistationService.getInstance();
		
		private CourseRegistationController() {}
		public static CourseRegistationController getInsance() {
			return instance;
		}
		
		
		/** ��� ���� �˻� */
		public void getCourseProject(String courseName) {
			
				try {
					EndSuccessView.courseView(service.getCourseProject(courseName));
				} catch (CourseNotFoundException e) {
					EndFailView.failView(e.getMessage());
					e.printStackTrace();
			}
		}
		
		
		/** ������û�� ��� ���� �˻� */
		public void getCourseProjectList() {
			EndSuccessView.courseListView(service.getCourseProjectList());
		}

		
		/** �ű԰��� ������û */
		public void courseInsert(CourseRegistation course) {
			
			Optional<CourseRegistation> opt = Optional.ofNullable(course);
			opt.ifPresent((data) -> {
				try {
					service.courseInsert(course);
				} catch (CourseNameDuplicationException e) {
					EndFailView.failView(e.getMessage());
					e.printStackTrace();
				}			
			});
			
			if(!opt.isPresent()) {
				EndFailView.failView("�����ϰ��� �ϴ� ������ ��ü�� �����ϴ�.");
			}
		}
		
		
		/** ������ ������ ���� - ��������� �˻��ؼ� �ش� ������ ������ ���� */
		public void courseProfessorUpdate(String courseName, Professor pName) {
			
			if(courseName != null && pName != null) {
				try {
					service.courseProfessorUpdate(courseName, pName);
					EndSuccessView.successView("���� ���� ���� ����");
				} catch (CourseNotFoundException | CourseNameDuplicationException e) {
					EndFailView.failView(e.getMessage());
					e.printStackTrace();
				}
			}else {
				EndFailView.failView("������ ���� ������ Ȯ�����ּ���.");
			}		
		}
		
		
		/** ������ �л��� ���� - ��������� �˻��ؼ� �ش� ������ �л��� ���� */
		public void courseStudentUpdate(String courseName, Student sName) {
			
			if(courseName != null && sName != null) {
				try {
					service.courseStudentUpdate(courseName, sName);
					EndSuccessView.successView("�л� ���� ���� ����");
				} catch (CourseNotFoundException | CourseNameDuplicationException e) {
					EndFailView.failView(e.getMessage());
					e.printStackTrace();
				}
			}else {
				EndFailView.failView("������ �л� ������ Ȯ�����ּ���.");
			}
			
		}
		
		
		/** ���� ���� - ��������� �ش� ���� ���� */
		public void courseDelete(String courseName) {
			
			Optional<String> opt = Optional.ofNullable(courseName);
			
			opt.ifPresent((name)->{
				boolean result = service. courseDelete(courseName);
				if(result) {
					EndSuccessView.successView(courseName+" ������Ʈ ���� ����");
				}else {
					EndFailView.failView("�����Ϸ��� ������Ʈ�� �������մϴ�.");
				}
			});
			
			if(!opt.isPresent()) {
				EndFailView.failView("�����Ϸ��� ������Ʈ���� �Է��ϼ���.");
			}
			
		}
		
		
		/** �л��� ������û ���� Ȯ�� */
		public void courseConfirm(String major) {
			try {
				EndSuccessView.courseView(service.courseConfirm(major));
			} catch (MajorNotFoundException e) {
				EndFailView.failView(e.getMessage());
				e.printStackTrace();
			}
		}

}
