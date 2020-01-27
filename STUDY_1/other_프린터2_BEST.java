package STUDY_1;

public class other_프린터2_BEST {
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		int[] order = new int[10];
		boolean[] flag = new boolean[101]; 
		int max_pri = 0, idx = 0 ;
		
		for(int v : priorities) order[v]++; //우선순위에 해당하는 출력물 갯수 기록하기
		
		while(true) {
			for(int i = 0; i<order.length; i++) if(order[i]!=0) max_pri = i; //가장 높은 우선순위 저장하기
			if(!flag[idx]) {
				if(priorities[idx]==max_pri) {
					flag[idx]=true;
					order[max_pri]--;
					answer++;
					if(idx==location) break;
				}
			}
			if(idx==priorities.length-1) idx=0;
			else idx++;
			
		}
		
		return answer;
	}
	public static void main(String[] args) {
		int[] test = {1, 1, 9, 1, 1, 1};
		int result = solution(test,0);
		System.out.println(result);
	}
}
