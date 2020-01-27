package STUDY_1;

import java.util.ArrayList;
import java.util.List;

public class my_프린터 {
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int v : priorities) list.add(v);
		
		while(!list.isEmpty()) {
			int tmp = list.get(0); //첫 번째 출력물 변수에 담기
			int size = list.size(); //리스트 remove과정에서 길이가 달라질 수 있으니 변수에 담기
			boolean flag = false; //출력순서가 바뀌었는지 확인하는 변수
			for(int i = 1; i<size; i++) {
				if(tmp<list.get(i)) {
					list.remove(0); //첫 번째 출력물보다 우선순위가 높은 출력물이 존재하여 첫 번째 출력물을 맨 뒤로 넣는 과정 
					list.add(tmp);
					if(location>0)location--; //기존의 원하는 출력물의 순서 하나 줄이기
					else location=list.size()-1;
					flag = true;
					break;
				}
			}
			
			if(!flag) { //우선순위가 바뀌지 않고 첫 번째 출력물이 출력될 때
				list.remove(0);
				answer++; //출력물 하나가 나갔으니까 카운팅 하나 올리기
				if(location==0) break; //나간 출력물이 원하는 출력물과 일치하면 break
				else location--; //아직 아니라면 순서 하나 줄이기
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		int[] test = {2, 1, 3, 2};
		int result = solution(test,2);
		System.out.println(result);
	}
}
