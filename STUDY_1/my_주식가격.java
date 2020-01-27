package STUDY_1;


public class my_주식가격 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        System.out.println(Integer.toBinaryString(10));
        for(int i = 0; i < prices.length; i++) {
        	int tmp = prices[i];
        	int cnt = 0;
        	for(int j = i+1 ; j<prices.length; j++) {
        		if(tmp<=prices[j]) cnt++;
        		else {
        			cnt++;
        			break;        			
        		}
        	}
        	answer[i]=cnt;
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] prices = {1,2,3,2,3};
		int[] answer = solution(prices);
		for(int v : answer) System.out.print(v);
	}
}
