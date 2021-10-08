package kr.or.shi.grade;

public class PFEvaluation implements GradeEvaluation {

	public String getGrade(int score) {
		String grade;
		if(score>=70) 
			grade = "PASS";
		else 
			grade = "FAIL";
		
		return grade;
	}
}
