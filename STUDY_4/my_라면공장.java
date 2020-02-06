package STUDY_4;

import java.util.Comparator;
import java.util.PriorityQueue;

public class my_라면공장 {
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
	    int answer = 0;
	    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
	    int idx = 0;
	    for(int i = 0; i < k; i++){
	    	if(idx<dates.length && i==dates[idx]) {
	    		pq.add(supplies[idx]);
	    		idx++;
	    	}
	    	
	        if(stock==0) {
	        	stock+=pq.poll();
	        	answer++;
	        }
	        stock--;
	    }
	    return answer;
	}
    public static void main(String[] args) {
    	int[] dates = {4,10,15};
    	int[] supplies = {20,5,10};
    	System.out.println(solution(4,dates,supplies,30));
    }
}
