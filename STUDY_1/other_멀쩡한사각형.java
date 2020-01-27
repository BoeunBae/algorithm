package STUDY_1;

import java.math.BigInteger;
//대각선을 지나는 사각형의 공식 : 양변 더한 값 - 양변의 최대공약수
//양변이 서로소이면 w+h-1인데, 일반적인 사각형은 서로소가 아닐 수 있으므로 최대공약수를 곱해주면 원래 양변의 값 - 양변의 최대공약수의 형태가 나온다.  
public class other_멀쩡한사각형 {

	public static long solution(int w, int h) {
		long total = (long)w*(long)h;
		long diagnoal = w + h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue(); //양 변의 길이 더한 값에 양 변의의 최대공약수를 뺀다? 
		return total-diagnoal;
	}
}
