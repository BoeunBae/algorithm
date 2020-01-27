package STUDY_2;

public class my_조이스틱 {
//AAA는 틀린 답으로 나오는 코드	
	public static int solution(String name) {
	    int answer = 0;
	    int exp = name.length()-1;
	    for(int i = 0; i<name.length(); i++) {
	    	char c = name.charAt(i);
			if(c!='A' && c >= 'N') answer += 'Z'-c+1;
			else if(c!='A' && c < 'N') answer += c-'A';
			
			if(c == 'A'){
	           int nextIdx = i+1;
	           int countA = 0;
	           while (nextIdx < name.length() &&
	                  name.charAt(nextIdx) == 'A'){
	               countA ++;
	               nextIdx++;
	           }
	           int tmp = (i-1)*2 + (name.length() -1 -i - countA) ;
	           if(exp > tmp) exp = tmp;
	       }
		}
	    
	    
		answer += exp;
	    return answer;
	}
}
