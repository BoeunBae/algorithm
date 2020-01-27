package STUDY_2;

public class other_종이접기_BEST {
//재귀함수 이용!
//내 코드보다 훨씬 짧게 수행된다.

	public int[] solution(int n) {

		if(n == 1) return new int[]{0};
		int tmp[] = solution(n - 1);
		int answer[] = new int[tmp.length * 2 + 1];
		
		for(int i = 0; i < answer.length; i++){
		    if(i < tmp.length) answer[i] = tmp[i];
		    else if(i == tmp.length) answer[i] = 0;
		    else answer[i] = tmp[answer.length - 1 - i] == 1 ? 0 : 1;
		}
		
		return answer;
	}
}

