package kr.or.shi.school;

public class Score {

	private String studentClass;				
	private Subject subject;			
	private int score;					
	
	public Score(String string, Subject subject, int score) {
		this.studentClass = string;
		this.subject = subject;
		this.score = score;
	}

	public String getStudentId() {
		return studentClass;
	}

	public Subject getSubject() {
		return subject;
	}

	public int getScore() {
		return score;
	}
}
