package STUDY_1;

import java.util.ArrayList;
import java.util.List;
//stream,람다함수 사용, 코드가 간결, 내코드보다 오래걸림
public class other_프린터 {
	public static int solution(int[] priorities, int location) {
		List<Integer> list = new ArrayList<Integer>();
		for(int v : priorities) list.add(v);
		
		int turn = 1;
		while(!list.isEmpty()) {
			int i = list.get(0);
			if(list.stream().anyMatch(j->i<j)) {
				list.add(list.remove(0));
			}
			else {
				if(location==0)return turn;
				turn++;
				list.remove(0);
			}
			
			if(location>0) location--;
			else location=list.size()-1;
		}
//	    return turn;
	    throw new IllegalArgumentException();
	}	
}
