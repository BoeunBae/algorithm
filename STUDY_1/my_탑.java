package STUDY_1;

import java.util.Stack;

public class my_탑 {
	public static int[] solution(int[] heights) {
		int[] answer = {};
		String strAnswer = "";
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> tmpStack = new Stack<Integer>();
		for(int v : heights) stack.add(v);
		
		while(!stack.isEmpty()) {
			int tmp = stack.pop();
			boolean flag = false;
			while(!stack.isEmpty()) {
				if(tmp<stack.peek()) {
					strAnswer = stack.size()+strAnswer; //스택특성상 답을 얻는 순서와 배열의 순서가 반대이므로 기존의 strAnswer을 뒤에 붙여준다. 
					flag = true; //수신할 탑이 있음을 플래그로 설정
					break;
				}else {
					tmpStack.add(stack.pop());//수신할 탑이 없으면 이어서 탑을 조사하기 위해 임시 스택에 저장
				}
			}
			if(!flag)strAnswer = 0+strAnswer; //수신할 탑이 없으면 0을 답으로 기입
			if(tmpStack.size()!=0) { //임시 스택에 있는 데이터를 다시 원래 스택에 돌려놓는 과정
				int cnt = tmpStack.size();
				for(int i = 0; i<cnt; i++) stack.add(tmpStack.pop());
			}
		}
		
		answer = new int[strAnswer.length()];
		for(int i = 0 ; i<answer.length; i++) {
			answer[i]=Integer.parseInt(strAnswer.split("")[i]);
		}
		
		return answer;
	}
	
    public static void main(String[] args) {
		int[] heights = {1,5,3,6,7,6,5};
		int[] answer = solution(heights);
		for(int v : answer) {
			System.out.println(v);
		}
	}
}
