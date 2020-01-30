package STUDY_3;

import java.math.BigInteger;

public class my_2xn타일링 {
	  public int solution(int n) {
			int answer = 0;
			int a = 1,b = 1;
			for(int i = 1; i<n; i++) {
				answer = (a+b)%1000000007;
				a=b;
				b=answer;
			}
			return b;
	  }
}
