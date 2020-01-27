package STUDY_2;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class my_종이접기 {
	public static int[] solution(int n) {
	    int[] answer = {0};
	    List<Integer> list = new ArrayList<Integer>();
	    list.add(0);
	    
	    if(n==1) return answer;
	    else {
	    	for(int i = 2; i<=n; i++) {
	    		Stack<Integer> stack = new Stack<Integer>();
	    		for(int v : list) stack.add(v);
	    		list.add(0);
	    		while(!stack.isEmpty())list.add(stack.pop()==0?1:0);
	    	}
	    }
	    answer=new int[list.size()];
	    for(int i = 0; i<answer.length; i++)answer[i] = list.get(i);
	    return answer;
	}
	
	public static void main(String[] args) {
		int[] answer = solution(2);
		for(int v : answer) System.out.print(v);
	}
}


