package STUDY_2;

import java.util.Stack;
public class my_괄호변환 {

	public static String solution(String p) {
		    String answer = recur(p);
		    return answer;
		}
		
		public static boolean isRight(String p) { //올바른 괄호인지 확인하는 메소드
			boolean result = true;
			Stack<Character> stack = new Stack<Character>();
			for(char c : p.toCharArray()) {
				if(c=='(') stack.push(c);
				else {
					if(!stack.isEmpty() && stack.peek()=='(') stack.pop();
					else {
						result=false;
					}
				}
			}
			return result;
		}
		
		public static String recur(String w) {
			if(w.equals("")) return w;
			else {
				int cnt = 0;
				int i;
				for(i = 0; i<w.length(); i++) {
					if(w.charAt(i)=='(') cnt++;
					else cnt--;
					if(cnt==0) break; 
				}
				String u = w.substring(0,i+1);//균형잡힌 괄호
				String v = w.substring(i+1);
				if(isRight(u)) return u + recur(v);//u가 올바른 괄호라면 v를 재귀처리
				else {
					String tmp = '('+recur(v)+')';
					u = u.substring(1,u.length()-1);
					StringBuilder sb = new StringBuilder();
					for(char c : u.toCharArray()) {
						if(c=='(') sb.append(')');
						else sb.append('(');
					}
					tmp+=sb.toString();
					return tmp;
				}
			}
		}

}
