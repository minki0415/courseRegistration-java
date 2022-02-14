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

	/** ��� ���� �˻� */
	public ArrayList<CourseRegistation> getCourseProjectList() {

		return courseProjectList;
	}

	/** ���� �̸����� �˻� */
	public CourseRegistation getCourseProject(String courseName) throws CourseNotFoundException {

		for (CourseRegistation c : courseProjectList) {
			if (c.getCourseName().equals(courseName)) {
				return c;
			}
		}
		throw new CourseNotFoundException("�ش� ������ �������� �ʽ��ϴ�.");

	}

	/** ���ο� ���� �߰� */
	public void courseInsert(CourseRegistation project) throws CourseNameDuplicationException {

		for (CourseRegistation c : courseProjectList) {
			if (c.getCourseName().equals(project.getCourseName())) {
				throw new CourseNameDuplicationException("�̹� �����ϴ� ���� �Դϴ�.");
			}
		}
		courseProjectList.add(project);

	}

	/** ������ ������ ���� - ��������� �˻��ؼ� �ش� ������ ������ ���� */
	public void courseProfessorUpdate(String courseName, Professor pName)
			throws CourseNameDuplicationException, CourseNotFoundException {

		for (CourseRegistation c : courseProjectList) {
			if (c.getCourseName().equals(courseName)) {
				c.setCourseProfessor(pName);
				return;
			}
		}
		throw new CourseNotFoundException("���� ������ �����ϰ��� �ϴ� ������ �������� �ʽ��ϴ�.");

	}

	/** ������ �л��� ���� - ��������� �˻��ؼ� �ش� ������ �л��� ���� */
	public void courseStudentUpdate(String courseName, Student sName)
			throws CourseNameDuplicationException, CourseNotFoundException {

		for (CourseRegistation c : courseProjectList) {
			if (c != null && c.getCourseName().equals(courseName)) {
				c.setCourseStudent(sName);
				return;
			}
		}
		throw new CourseNotFoundException("�л������� �����ϰ��� �ϴ� ������ �������� �ʽ��ϴ�.");

	}

	/** ���� ���� - ��������� �ش� ���� ���� */
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
	/** �л��� ������û ���� Ȯ�� */
	public CourseRegistation courseConfirm(String major) throws MajorNotFoundException {

		for (CourseRegistation course : courseProjectList) {
			if (course.getCoursePossibleMajor().equals(major)) {
				return course;
			}
		}
		throw new MajorNotFoundException("�������� Ȯ�����ּ���.");

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
