package STUDY_6;

public class other_제이든문자열만들기{
	public static String solution(String s) {
		String answer = "";
		String[] arr = s.toLowerCase().split("");
		boolean flag = true;
		for(String v : arr) {
			answer+=flag? v.toUpperCase():v;
			flag=v.equals(" ")?true:false;
		}
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(solution("3People"));
	}
}
