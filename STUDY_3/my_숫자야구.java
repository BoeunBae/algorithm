package STUDY_3;

public class my_숫자야구 {
	public static int solution(int[][] baseball) {
	    int answer = 0;
	    int strike = 0;
	    int boll = 0;
	    for(int i = 123; i<=987; i++){
	        String num = Integer.toString(i);
	        String[] numArray = num.split("");
	        if(num.contains("0")) continue;
	        if(numArray[0].equals(numArray[1]) || numArray[0].equals(numArray[2]) || numArray[1].equals(numArray[2])) continue;
	
	        boolean flag = true;
	        for(int j = 0; j<baseball.length; j++) {
	        	strike = 0;
	            boll = 0;
	            String q = Integer.toString(baseball[j][0]);
	            String[] qArray = q.split("");
	            for(int a = 0; a<3; a++) {
	            	for(int b = 0; b<3; b++) {
	            		if(a==b && numArray[a].equals(qArray[b])) {
	            			strike++;
	            			continue;
	            		}
	            		if(a!=b && numArray[a].equals(qArray[b])) {
	            			boll++;
	            			continue;
	            		}
	            	}
	            }
	            if(strike!=baseball[j][1] || boll != baseball[j][2]) flag=false;
	        }
	        
	        if(flag) answer++; 
	        
	    }
	    return answer;
	}
	public static void main(String[] args) {
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		System.out.println(solution(baseball));
	}
}
