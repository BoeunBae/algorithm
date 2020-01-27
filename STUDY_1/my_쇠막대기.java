package STUDY_1;

import java.util.Stack;

public class my_쇠막대기 {
    public static int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<Character>();
   
        for(int i = 0; i<arrangement.length(); i++) {
        	char c = arrangement.charAt(i);
        	if(c=='(') stack.push(c); //(를 만나면 스택에 넣기
        	else {
        		stack.pop(); //)를 만나면 직전에 만난 값 빼두기
        		if(arrangement.charAt(i-1)=='(') { //직전 값이 (이면 레이저이므로 스택에 담겨있는 (의 개수가 막대가 잘리고 생겨난 조각의 개수
        			answer+=stack.size();
        		}else answer+=1; //직전 값이 ) 이면 막대기의 마지막 부분이라는 의미로 레이저로 잘리고 남은 막대기의 남은 부분이므로 하나 더해주기
        	}
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
		System.out.println(solution("()(((()())(())()))(())"));
	}
}
