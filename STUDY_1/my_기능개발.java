package STUDY_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class my_기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		
		List<Integer> answerList = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		List<Integer> list_s = new ArrayList<Integer>();
		for(int v : progresses) q.add(v);
		for(int v : speeds) list_s.add(v);
		
		while(!q.isEmpty()) {
			int size  = list_s.size();
			for(int i = 0 ; i<size; i++) { //speed사이즈에 맞게 진행상황 업데이트
				q.add(q.poll()+list_s.get(i));
			}
			if(q.peek()>=100) { //우선순위 높은 작업의 진행이 100이 된 경우
				int cnt = 0;
				while(true) {
					 if(!q.isEmpty()&&q.peek()>=100) {//큐가 비어있지 않을 동안 100이상인 작업 찾기, poll을 사용하면 큐에서 빠져버리니까 빼기전에 확인하기!
						 q.poll();
						 list_s.remove(0); //리스트의 특징 : 앞의 데이터가 사라지면 인덱스 자동 변경되므로 0번째 인덱스 삭제하여 speedList 관리
						 cnt++;
					 }else {
						 answerList.add(cnt);
						 break;
					 }
				}
			}
		}
		
		answer = new int[answerList.size()];
		for(int i = 0; i<answer.length; i++) {
			answer[i] = answerList.get(i);
		}
		
		return answer;
	}
}
