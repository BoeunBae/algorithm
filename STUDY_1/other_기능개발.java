package STUDY_1;

import java.util.Arrays;
//람다식, Stream사용(내 코드보다는 시간 오래걸림)
public class other_기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = new int[100];
		int day = 0;
		for(int i = 0; i<progresses.length; i++) {
			while(progresses[i]+(day*speeds[i])<100) { //날짜를 카운팅해서 100이상이되면
				day++;
			}
			answer[day]++; //해당날짜의 완성된 기능 카운팅올리기
		}
		return Arrays.stream(answer).filter(i->i!=0).toArray();
	}
}
