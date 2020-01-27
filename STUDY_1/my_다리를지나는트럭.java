package STUDY_1;

import java.util.LinkedList;
import java.util.Queue;

class Truck{ //트럭정보를 담기위한 클래스
	int weight;
	int time;
	
	public Truck(int weight, int time) {
		this.weight = weight;
		this.time = time;
	}
	
}


public class my_다리를지나는트럭 {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 1;
		Queue<Truck> before = new LinkedList<Truck>();
		Queue<Truck> on = new LinkedList<Truck>();
		for(int v : truck_weights) before.add(new Truck(v, 0));
		
		on.add(before.poll()); //이미 다리에 올려놓고 시작했으니까 answer = 1 부터 시작하기
		while(!on.isEmpty()) {
			int total_weight = 0; //현재 다리 위에 있는 트럭의 무게를 구하기 위한 초기화
			for(Truck t : on) {
				total_weight+=t.weight; 
				t.time++; //트럭이 다리위에 있었던 시간 계산
			}
			
			if(on.peek().time==bridge_length) { //다리위에 있었던 시간이 다리길이와 일치하면 트럭은 지나간걸로 처리
				total_weight-=on.peek().weight;
				on.poll();
			}
			
			if(!before.isEmpty() && total_weight+before.peek().weight <= weight) on.add(before.poll());
			
			answer++;
	
		}
		
		return answer;
	}
	public static void main(String[] args) {
		int[] truck = {7,4,5,6};
//		int[] truck = {10};
		System.out.println(solution(10,10,truck));
	}
}
