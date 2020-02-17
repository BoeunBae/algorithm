package STUDY_6;

import java.util.Stack;

public class my_짝지어제거하기 {
	 public int solution(String s){
	        int answer = 0;
	        Stack<Character> stack = new Stack<Character>();
	        
	        for(int i = 0; i<s.length(); i++){
	            if(i==0) {
	                stack.push(s.charAt(i));
	                continue;
	            }
	            if(!stack.isEmpty() && stack.peek()==s.charAt(i)){
	                stack.pop();                
	            }else stack.push(s.charAt(i));
	            
	            if(stack.isEmpty() && i==s.length()-1) answer=1;
	        }
	    
	        return answer;
	    }
}
