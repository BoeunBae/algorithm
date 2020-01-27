package STUDY_2;

public class other_조이스틱 {
	public static int solution(String name) {
	    int answer = 0;
	    for(int i = 0; i<name.length(); i++) {
	    	char c = name.charAt(i);
			if(c!='A' && c >= 'N') answer += 'Z'-c+1;
			else if(c!='A' && c < 'N') answer += c-'A';
		}
	    
	    
	    return answer;
	}
}
