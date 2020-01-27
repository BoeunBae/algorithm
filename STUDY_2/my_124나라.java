package STUDY_2;

public class my_124나라 {
	public String solution(int n) {
		if(n>3) return solution((n-1)/3).concat(solution(n%3));
		
		String result = "";
		if(n==3||n==0) result = "4";
		else if(n==2) result ="2";
		else if(n==1) result = "1";
		
		return result;
	}
}
