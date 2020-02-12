package STUDY_5;

public class my_다음큰숫자 {
	  public int solution(int n) {
	      int answer = 0;
	      int cnt = 0;
	      char[] charArray = Integer.toBinaryString(n).toCharArray();
	      for(char v : charArray) if(v=='1') cnt++;
	      while(true) {
	    	  n = n+1;
	    	  int tmpCnt = 0;
		      for(char v : Integer.toBinaryString(n).toCharArray()) if(v=='1') tmpCnt++;
		      if(tmpCnt==cnt)break;
	      }
	      answer = n;
	      return answer;
	  }
}
