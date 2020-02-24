package STUDY_6;

import java.util.Arrays;
import java.util.LinkedList;

public class my_디스크컨트롤러 {
    public static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1,o2)->{
//        	if(o1[1]==o2[1])return Integer.compare(o1[0], o2[0]);
//        	else return Integer.compare(o1[1], o2[1]);
        	return Integer.compare(o1[1], o2[1]);
        });
        LinkedList<int[]> list = new LinkedList<int[]>();
        for(int[] job : jobs) list.add(job);
        int cnt = 0;
        int sum = 0;
        while(!list.isEmpty()) {
        	for(int i = 0; i<list.size(); i++) {
        		if(cnt>=list.get(i)[0]) {
            		int[] tmp = list.get(i);
            		cnt+=tmp[1];
            		sum+=cnt-tmp[0];
            		list.remove(i);
            		break;
            	}	
        		if(i==list.size()-1) cnt++;
        	}
        }
        answer = sum / jobs.length;
        return answer;
    }
    
    public static void main(String[] args) {
		int[][] jobs = {{0,3},{1,9},{2,6}};
		System.out.println(solution(jobs));
	}
}
