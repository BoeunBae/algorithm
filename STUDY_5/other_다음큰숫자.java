package STUDY_5;

public class other_다음큰숫자 {
	  public static int solution(int n) { //bitCount 메소드 활용
	      int answer = 0;
	      int cnt = Integer.bitCount(n);
	      while(true) {
	    	  n = n+1;
	    	  int tmpCnt = Integer.bitCount(n);
		      if(tmpCnt==cnt)break;
	      }
	      answer = n;
	      return answer;
	  }
	  public static int solution2(int n) { //사칙연산 규칙 활용
		  int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
		  return n + postPattern | smallPattern ;
	  }
	  public static void main(String[] args) {
		System.out.println(solution(78));
		System.out.println(solution2(2));
		
		
	}
}
