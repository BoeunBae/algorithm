package STUDY_1;

public class my_멀쩡한사각형 {
	public static long solution(int w, int h) {
		long answer = 0;
		long cnt = 0;
		for(int i = 0; i<w; i++) {
			cnt = (long)h * (long) i / (long)w; //대각선 위의 사각형들 갯수 더하는 원리?
			answer += cnt*2;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(8,12));
	}
}
