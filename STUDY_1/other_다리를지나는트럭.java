package STUDY_1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
//내코드보다 오래걸림
public class other_다리를지나는트럭 {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		for(int v : truck_weights) q.add(v);
		
		while(true) {
			answer++;
			
			if(map.containsKey(answer)) { //트럭이 다리에 올라왔을 때의 시간 + 트럭이 다리를 지나는 시간의 값을 key로 하는 map 존재하면 삭제
				map.remove(answer);
			}
			
			sum = 0;
			for(int v : map.values()) {
				sum+=v; //다리위에 있는 트럭 무게 총합
			}			
			
			if(!q.isEmpty() && sum+q.peek()<=weight) map.put(answer+bridge_length, q.poll());
			//트럭이 다리에 올라왔을 때의 시간 + 트럭이 다리를 지나는 시간 = 해당 트럭이 다리를 완전히 지낫을 때의 시간,트럭의 무게를 키와 밸류로 갖는 맵 생성
			
			if(q.isEmpty() && map.isEmpty()) break;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int[] array = {7,4,5,6};
		System.out.println(solution(2,10,array));
	}
}
