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
		
		
		/** 모든 과목 검색 */
		public void getCourseProject(String courseName) {
			
				try {
					EndSuccessView.courseView(service.getCourseProject(courseName));
				} catch (CourseNotFoundException e) {
					EndFailView.failView(e.getMessage());
					e.printStackTrace();
			}
		}
		
		
		/** 수강신청한 모든 과목 검색 */
		public void getCourseProjectList() {
			EndSuccessView.courseListView(service.getCourseProjectList());
		}

		
		/** 신규강의 수강신청 */
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
				EndFailView.failView("저장하고자 하는 데이터 자체가 없습니다.");
			}
		}
		
		
		/** 과목의 교수명 수정 - 과목명으로 검색해서 해당 과목의 교수명 수정 */
		public void courseProfessorUpdate(String courseName, Professor pName) {
			
			if(courseName != null && pName != null) {
				try {
					service.courseProfessorUpdate(courseName, pName);
					EndSuccessView.successView("교수 정보 갱신 성공");
				} catch (CourseNotFoundException | CourseNameDuplicationException e) {
					EndFailView.failView(e.getMessage());
					e.printStackTrace();
				}
			}else {
				EndFailView.failView("변경할 교수 정보를 확인해주세요.");
			}		
		}
		
		
		/** 과목의 학생명 수정 - 과목명으로 검색해서 해당 과목의 학생명 수정 */
		public void courseStudentUpdate(String courseName, Student sName) {
			
			if(courseName != null && sName != null) {
				try {
					service.courseStudentUpdate(courseName, sName);
					EndSuccessView.successView("학생 정보 갱신 성공");
				} catch (CourseNotFoundException | CourseNameDuplicationException e) {
					EndFailView.failView(e.getMessage());
					e.printStackTrace();
				}
			}else {
				EndFailView.failView("변경할 학생 정보를 확인해주세요.");
			}
			
		}
		
		
		/** 과목 삭제 - 과목명으로 해당 과목 삭제 */
		public void courseDelete(String courseName) {
			
			Optional<String> opt = Optional.ofNullable(courseName);
			
			opt.ifPresent((name)->{
				boolean result = service. courseDelete(courseName);
				if(result) {
					EndSuccessView.successView(courseName+" 프로젝트 삭제 성공");
				}else {
					EndFailView.failView("삭제하려는 프로젝트가 미존재합니다.");
				}
			});
			
			if(!opt.isPresent()) {
				EndFailView.failView("삭제하려는 프로젝트명을 입력하세요.");
			}
			
		}
		
		
		/** 학생의 수강신청 정보 확인 */
		public void courseConfirm(String major) {
			try {
				EndSuccessView.courseView(service.courseConfirm(major));
			} catch (MajorNotFoundException e) {
				EndFailView.failView(e.getMessage());
				e.printStackTrace();
			}
		}

}
