package service;

import java.util.ArrayList;

import exception.CourseNameDuplicationException;
import exception.CourseNotFoundException;
import exception.MajorNotFoundException;
import model.dto.CourseRegistation;
import model.dto.Professor;
import model.dto.Student;

public class CourseRegistationService {

	private static CourseRegistationService instance = new CourseRegistationService();
	private ArrayList<CourseRegistation> courseProjectList = new ArrayList<CourseRegistation>();

	private CourseRegistationService() {
	}

	public static CourseRegistationService getInstance() {
		return instance;
	}

	/** 모든 과목 검색 */
	public ArrayList<CourseRegistation> getCourseProjectList() {

		return courseProjectList;
	}

	/** 과목 이름으로 검색 */
	public CourseRegistation getCourseProject(String courseName) throws CourseNotFoundException {

		for (CourseRegistation c : courseProjectList) {
			if (c.getCourseName().equals(courseName)) {
				return c;
			}
		}
		throw new CourseNotFoundException("해당 과목은 존재하지 않습니다.");

	}

	/** 새로운 과목 추가 */
	public void courseInsert(CourseRegistation project) throws CourseNameDuplicationException {

		for (CourseRegistation c : courseProjectList) {
			if (c.getCourseName().equals(project.getCourseName())) {
				throw new CourseNameDuplicationException("이미 존재하는 과목 입니다.");
			}
		}
		courseProjectList.add(project);

	}

	/** 과목의 교수명 수정 - 과목명으로 검색해서 해당 과목의 교수명 수정 */
	public void courseProfessorUpdate(String courseName, Professor pName)
			throws CourseNameDuplicationException, CourseNotFoundException {

		for (CourseRegistation c : courseProjectList) {
			if (c.getCourseName().equals(courseName)) {
				c.setCourseProfessor(pName);
				return;
			}
		}
		throw new CourseNotFoundException("교수 정보를 수정하고자 하는 과목이 존재하지 않습니다.");

	}

	/** 과목의 학생명 수정 - 과목명으로 검색해서 해당 과목의 학생명 수정 */
	public void courseStudentUpdate(String courseName, Student sName)
			throws CourseNameDuplicationException, CourseNotFoundException {

		for (CourseRegistation c : courseProjectList) {
			if (c != null && c.getCourseName().equals(courseName)) {
				c.setCourseStudent(sName);
				return;
			}
		}
		throw new CourseNotFoundException("학생정보를 수정하고자 하는 과목이 존재하지 않습니다.");

	}

	/** 과목 삭제 - 과목명으로 해당 과목 삭제 */
	public boolean courseDelete(String courseName) {

		int count = courseProjectList.size();
		for (int i = 0; i < count; i++) {
			if (courseProjectList.get(i).getCourseName().equals(courseName)) {
				courseProjectList.remove(i);
				return true;
			}
		}
		return false;

	}

	// CourseRegistation
	/** 학생의 수강신청 정보 확인 */
	public CourseRegistation courseConfirm(String major) throws MajorNotFoundException {

		for (CourseRegistation course : courseProjectList) {
			if (course.getCoursePossibleMajor().equals(major)) {
				return course;
			}
		}
		throw new MajorNotFoundException("전공명을 확인해주세요.");

	}
	
//	CourseRegistation course = null;
//	public CourseRegistation courseConfirm(String major) {
//
//		System.out.println("-------------------------");
//		courseProjectList.stream().forEach(v -> {
//			if(v.getCoursePossibleMajor().equals(major)) {
//				course = v;//
//			}
//		});
//		return course;
//
//	}

}
