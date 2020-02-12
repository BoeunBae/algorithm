package STUDY_5;

import java.util.ArrayList;
import java.util.List;

public class my_섬연결하기 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] bridge = new int[n][n];
        for(int i = 0; i < costs.length; i++) {
        	bridge[costs[i][0]][costs[i][1]] = bridge[costs[i][1]][costs[i][0]] = costs[i][2];
        }
        boolean[] visit = new boolean[n];
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        visit[0]=true;
        while(list.size()<n) {
        	int min = Integer.MAX_VALUE;
        	int minIdx = -1;
        	for(int tmp = 0; tmp<list.size(); tmp++) {
        		int i = list.get(tmp);
        		for(int j = 0; j<n; j++) {
        			if(i!=j && !visit[j] && bridge[i][j]!=0 && bridge[i][j]<min) {
        				min=bridge[i][j];
        				minIdx=j;
        			}
        		}
        	}
        	visit[minIdx]=true;
        	list.add(minIdx);
        	answer+=min;
        }
        
        return answer;
    }
}
