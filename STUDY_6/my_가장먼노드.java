package STUDY_6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class my_가장먼노드 {
    public int solution(int n, int[][] edge) {
	 	int answer = 0;
        boolean[][] map = new boolean[n+1][n+1];
        int[] arr = new int[n+1];
        for(int i = 0; i<edge.length; i++) 
            map[edge[i][0]][edge[i][1]] = map[edge[i][1]][edge[i][0]] = true;
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        while(!q.isEmpty()){
            int s = q.poll();
            for(int i = 2; i<n+1; i++){
                if(map[s][i]&&arr[i]==0){
                    q.add(i);
                    arr[i]=arr[s]+1;
                }
            }
        }
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        for(int i = arr.length-1; i>0; i--){
            if(max==arr[i]){
                answer++;
            }
        }
        return answer;
    }
    
    public int solution_2(int n, int[][] edge) {

        int answer = 0;
        boolean[][] map = new boolean[n+1][n+1];
        boolean[] chk = new boolean[n+1];
        for(int i = 0; i<edge.length; i++) 
            map[edge[i][0]][edge[i][1]] = map[edge[i][1]][edge[i][0]] = true;
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        chk[1]=true;
        
        while(!q.isEmpty()){
            answer = q.size(); 
    
            for(int t= 0; t<answer; t++){
	            int s = q.poll();
	    
	            for(int i=1; i<=n ; i++){
		            if(!chk[i]&&map[s][i]){
		            chk[i]=true;
		            q.add(i);
		            }
	            }
            }
        }
        return answer;
    }
}
