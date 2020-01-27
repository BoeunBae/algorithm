package STUDY_2;

import java.util.Stack;

public class other_큰수만들기 {
	public static String solution(String number, int k) {
		char[] answer = new char[number.length()-k];
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i<number.length(); i++) {
			char c = number.charAt(i);
			while(!stack.isEmpty() && stack.peek() < c && k-- > 0) { //앞에서부터 비교하면서 작은 값을 k만큼 빼는 원리
				stack.pop();
			}
			stack.push(c);
		}
		for(int i = 0; i<answer.length; i++)answer[i]=stack.get(i);
		return new String(answer);
	}
}
