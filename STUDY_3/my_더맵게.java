package STUDY_3;

import java.util.PriorityQueue;

public class my_더맵게 {
	 public int solution(int[] scoville, int K) {
	        int answer = 0;
	        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	        for(int v : scoville) pq.add(v);
	        while(true){
	        	if(pq.peek()>=K) break;
	        	if(pq.size()<=1 && pq.peek()<K) {
	        		answer=-1;
	        		break;
	        	}
	        	int tmp = pq.poll()+(pq.poll()*2);
	        	pq.add(tmp);
	        	answer++;
	            
	        }
	        return answer;
	    }
}
