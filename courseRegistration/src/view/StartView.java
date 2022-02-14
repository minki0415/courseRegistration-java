package view;

import controller.CourseRegistationController;
import model.dto.CourseRegistation;
import model.dto.CourseType;
import model.dto.Professor;
import model.dto.Student;

public class StartView {

	public static void main(String[] args) {

		// 프로젝트 주제 : 수강 관리 프로그램

		// Professor(교수정보) 객체 생성
		// 교수이름, 학부, 교수메일, 과목명
		Professor professor1 = new Professor("김교수", "체육학과", "a123@gmail.com", "체육학개론");
		Professor professor2 = new Professor("반교수", "메카트로닉스공학부", "b123@gmail.com", "메카트로닉스개론");
		Professor professor3 = new Professor("홍교수", "컴퓨터공학과", "c123@gmail.com", "컴퓨터공학개론");
		Professor professor4 = new Professor("임교수", "수학과", "d123@gmail.com", "미적분학");
		Professor professor5 = new Professor("최교수", "체육학과", "e123@gmail.com", "농구");

		// Student(학생정보) 객체 생성
		// 학번, 학부, 이름, 연락처, 수강신청과목명
		Student student1 = new Student(20151111, "체육학과", "김민기", "010-1111-9999", "체육학개론");
		Student student2 = new Student(20122222, "메카트로닉스공학부", "반철준", "010-2222-9999", "메카트로닉스개론");
		Student student3 = new Student(20183333, "컴퓨터공학과", "홍도희", "010-3333-9999", "컴퓨터공학개론");
		Student student4 = new Student(20164444, "물리치료학과", "임혜진", "010-4444-9999", "체육학개론");
		Student student5 = new Student(20175555, "체육학과", "손흥민", "010-1873-7798", "체육학개론");

		// CourseType(강의타입) 객체 생성
		// 과목명, 강의커리큘럼,강의내용 예시
		CourseType physicalEducation = new CourseType("체육학개론", "체육원리,체육사,스포츠심리학", "체육의 목적과 정의,스포츠의 역사,스포츠심리학이란");
		CourseType mechatronicsEducation = new CourseType("메카트로닉스개론", "자동화시스템,센서공학,전자회로의기초", "자동화시스템의 목적,센서의종류,직류교류");
		CourseType computerEducation = new CourseType("컴퓨터공학개론","컴퓨터의개요,프로그래밍언어,데이터베이스","컴퓨터발전역사,프로그래밍언어 종류및특징,데이터모델");
		CourseType mathematicsEducation = new CourseType("미적분학", "함수,미분,적분", "함수의 성질,미분계수와 도함수,정적분");

		// CourseProject(강의) 객체 생성
		// 프로젝트(과목명), 교수, 수강생, 강의종류, 개강일, 종강일
		CourseRegistation physicalCourse = new CourseRegistation("체육강의", professor1, student1, physicalEducation,"체육학과", "2022-03-02", "2022-07-19");
		CourseRegistation mechatronicsCourse = new CourseRegistation("메카트로닉스강의", professor2, student2,mechatronicsEducation, "메카트로닉스공학부", "2022-03-02", "2022-07-19");
		CourseRegistation computerCourse = new CourseRegistation("컴퓨터강의", professor3, student3, computerEducation,"컴퓨터공학과", "2022-03-02", "2022-07-19");

		CourseRegistationController controller = CourseRegistationController.getInsance();

		// 출력 test
		// 수강신청하기
		System.out.println("*** 01. 수강신청 ***");
		controller.courseInsert(physicalCourse);
		controller.courseInsert(mechatronicsCourse);
		controller.courseInsert(computerCourse);

		// 수강신청한 모든 강의 조회
		System.out.println("\n*** 02. 수강신청한 강의 전체조회 ***");
		controller.getCourseProjectList();

		// 과목명으로 강의 검색하기
		System.out.println("\n*** 03. '체육강의' Project 검색 ***");
		controller.getCourseProject("체육강의");

		// 교수자 변경하기
		System.out.println("\n*** 04. '체육강의'의 교수명 변경(수정) 후 해당 과목 검색 ***");
		controller.courseProfessorUpdate("체육강의", professor5);

		// 학생 변경하기
		System.out.println("\n*** 05. '체육강의'의 학생명 변경(수정) 후 해당 과목 검색 ***");
		controller.courseStudentUpdate("체육강의", student5);
		controller.getCourseProject("체육강의");

		// 프로젝트 삭제하기
		System.out.println("\n*** 06. '' 선택한 과목 삭제 후 삭제된 과목 검색 ***");
		controller.courseDelete("메카트로닉스강의");
		controller.getCourseProject("메카트로닉스강의");

		// 수강신청 여부 확인하기
		System.out.println("\n*** 07. '' 수강신청가능한 과목 확인 ***");
		controller.courseConfirm("체육학과");
	}

}
