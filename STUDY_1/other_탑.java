package STUDY_1;
//이중포문 사용(내 코드보다 훨씬 빨리 계산되고 코드도 간결)
public class other_탑 {
	public static int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		
		for(int i = heights.length-1 ; i>=0; i--) {
			for(int j = i-1; j>=0; j--) {
				if(heights[i]<heights[j]) {
					answer[i]=j+1;
					break;
				}
			}
		}
		
		return answer;
	}
}
