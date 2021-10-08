package kr.or.shi.ui;

import kr.or.shi.school.School;
import kr.or.shi.school.Score;
import kr.or.shi.school.Student;
import kr.or.shi.school.Subject;
import kr.or.shi.school.view.GenerateGradeReport;
import kr.or.shi.utils.Constant;

public class UiMain {

	School sctSchool = School.getInstance();
	Subject hiphop;
	Subject modern;
	GenerateGradeReport gradeReport = new GenerateGradeReport();
	
	public static void main(String[] args) {
		
		UiMain uiMain = new UiMain();
		uiMain.createSubject();
		uiMain.createStudent();
		
		String report = uiMain.gradeReport.getReport();
		System.out.println(report);
	}

	//시험 학생 생성
	public void createStudent() {
		Student student1 = new Student("A", "예지", hiphop);
		Student student2 = new Student("B", "리아", modern);
		Student student3 = new Student("A", "류진", hiphop);
		Student student4 = new Student("A", "채령", hiphop);
		Student student5 = new Student("B", "유나", modern);
		
		sctSchool.addStudent(student1);
		sctSchool.addStudent(student2);
		sctSchool.addStudent(student3);
		sctSchool.addStudent(student4);
		sctSchool.addStudent(student5);
		
		hiphop.register(student1);
		hiphop.register(student2);
		hiphop.register(student3);
		hiphop.register(student4);
		hiphop.register(student5);
		
		modern.register(student1);
		modern.register(student2);
		modern.register(student3);
		modern.register(student4);
		modern.register(student5);
		
		
		this.addScoreForStudent(student1, hiphop, 95);
		this.addScoreForStudent(student1, modern, 88);
		
		this.addScoreForStudent(student2, hiphop, 60);
		this.addScoreForStudent(student2, modern, 69);
		
		this.addScoreForStudent(student3, hiphop, 90);
		this.addScoreForStudent(student3, modern, 77);
		
		this.addScoreForStudent(student4, hiphop, 65);
		this.addScoreForStudent(student4, modern, 88);
		
		this.addScoreForStudent(student5, hiphop, 80);
		this.addScoreForStudent(student5, modern, 75);
		
		

	}
	
	
	// 과목별 성적 입력
	public void addScoreForStudent(Student student, Subject subject, int score) {
		
		Score score1 = new Score(student.getStudentClass(), subject, score);
		student.addSubjectScore(score1);
		
	}

	public void createSubject() {
		hiphop = new Subject(Constant.HIPHOP, "힙합");
		modern = new Subject(Constant.MODERN, "현대무용");
		
		sctSchool.addSubject(hiphop);
		sctSchool.addSubject(modern);
	}
}
