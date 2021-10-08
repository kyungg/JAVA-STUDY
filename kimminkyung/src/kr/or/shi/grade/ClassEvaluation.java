package kr.or.shi.grade;

public class ClassEvaluation implements GradeEvaluation {

	public String getGrade(int score) {
		
		String grade;
		if(score>= 90 && score<=100)
			grade = "최우수";
		else if(score>=80 && score <=89)
			grade = "우수";
		else if(score>=75 && score <=79)
			grade = "장려";
		else
			grade = "입상";
		
		
		return grade;
		
	}
}
