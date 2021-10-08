package kr.or.shi.school;

import java.util.ArrayList;

public class Student {

	private String studentClass;			
	private String studentName; 	
	private Subject mainSubject;	
	private ArrayList<Score> scores	= new ArrayList<>();
	
	public Student(String string, String studentName, Subject mainSubject) {
		this.studentClass = string;
		this.studentName = studentName;
		this.mainSubject = mainSubject;
	}
	
	public void addSubjectScore(Score score) {
		scores.add(score);
	}

	public String getStudentClass() {
		return studentClass;
	}

	public String getStudentName() {
		return studentName;
	}

	public Subject getMainSubject() {
		return mainSubject;
	}

	public ArrayList<Score> getScores() {
		return scores;
	}
	
}
