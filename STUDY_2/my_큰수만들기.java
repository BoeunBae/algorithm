package STUDY_2;

public class my_큰수만들기 {
	public static String solution(String number, int k) {
	        StringBuilder sb = new StringBuilder();
	        String[] array = number.split("");
	        int n = number.length()-k;
	        int idx = -1;
	        for(int i = 0; i < n; i++) {
	        	int max = 0;
	        	for(int j = idx+1; j<=k+i; j++) {
	        		if(max==9) break;
	        		else {
	        			if(max<Integer.parseInt(array[j])) {
	        				max = Integer.parseInt(array[j]);
	        				idx=j;
	        			}
	        		}
	        	}
	        	sb.append(max);
	        }
	        return sb.toString();
	    }	
}
