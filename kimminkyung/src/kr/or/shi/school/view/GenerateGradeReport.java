package kr.or.shi.school.view;

import java.util.ArrayList;

import kr.or.shi.grade.ClassEvaluation;
import kr.or.shi.grade.GradeEvaluation;
import kr.or.shi.grade.PFEvaluation;
import kr.or.shi.school.School;
import kr.or.shi.school.Score;
import kr.or.shi.school.Student;
import kr.or.shi.school.Subject;
import kr.or.shi.utils.Constant;

public class GenerateGradeReport {
	School school = School.getInstance();
	public static final String TITLE = "  댄스 경진대회 \t\t\n";
	public static final String HEADER = " 이름 |  반  |  주종목  |  결과  \n";
	public static final String LINE = "--------------------------------------------\n";
	public static final String LINE2 = "============================================\n";
	
	private StringBuffer buffer = new StringBuffer();
	
	public String getReport() {
		ArrayList<Subject> subjects = school.getSubject();
		for(Subject subject : subjects) {
			makeHeader(subject);
			makeBody(subject);
		}
		return buffer.toString();
	}

	public void makeHeader(Subject subject) {
		buffer.append("\t" + subject.getSubjectName());
		buffer.append(GenerateGradeReport.TITLE);
		buffer.append(GenerateGradeReport.HEADER);
		buffer.append(GenerateGradeReport.LINE2);
	}
	
	//학생별 해당과목 학점 계산
	public void makeBody(Subject subject) {
		ArrayList<Student> students = subject.getStudents();
		for(int i=0; i<students.size(); i++) {
			Student student = students.get(i);
			buffer.append(student.getStudentName());
			buffer.append("  | ");
			buffer.append(student.getStudentClass());
			buffer.append("  | ");
			buffer.append(student.getMainSubject().getSubjectName()+ " ");
			buffer.append("  | ");
			GetScoreGrade(student, subject);
			buffer.append("\n");
			buffer.append(LINE);
		}
	}

	public void GetScoreGrade(Student student, Subject subject) {
		ArrayList<Score> scores = student.getScores();
		int majorId = student.getMainSubject().getSubjectId();
		
		//평가 클래스들
		GradeEvaluation[] gradeEvaluations = {new ClassEvaluation(), new PFEvaluation()};
		
		//학생이 가진 점수들
		for(int i=0; i<scores.size() ; i++) {
			Score score = scores.get(i);
			
			if(score.getSubject().getSubjectId() == subject.getSubjectId()) {
				String grade;
				
				if(score.getSubject().getSubjectId() == majorId) { // 주종목인 경우
					grade = gradeEvaluations[Constant.CLS_TYPE].getGrade(score.getScore());
				}
				else{
					grade = gradeEvaluations[Constant.FP_TYPE].getGrade(score.getScore());
				}
	
				buffer.append(score.getScore());
				buffer.append(" : ");
				buffer.append(grade);
				buffer.append(" | ");
			}
		
		}
	}
}
