package kr.or.shi.school;

import java.util.ArrayList;

import kr.or.shi.utils.Constant;

public class Subject {
	private int subjectId;			
	private String subjectName;		
	private int gradeType;	
	private ArrayList<Student> students = new ArrayList<>();
	
	public Subject(int subjectId, String subjectName) {
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.gradeType = Constant.CLS_TYPE;
	}
	
	public void register(Student student) {			
		students.add(student);
	}

	public int getSubjectId() {
		return subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public int getGradeType() {
		return gradeType;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}
}
