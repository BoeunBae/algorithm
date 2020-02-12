package STUDY_5;

public class my_네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] flag = new boolean[computers.length][computers.length];
        for(int i = 0; i<computers.length; i++){
            if(computers[i][i]==1 && !flag[i][i]){
                DFS(computers,flag,i);
                answer++;
            }
        }
        return answer;
    }
    
    public void DFS(int[][] computers, boolean[][] flag, int i){
        for(int idx = 0; idx<computers.length; idx++){
            if(computers[i][idx]==1 && !flag[i][idx]){
                flag[i][idx]=flag[idx][i]=true;
                DFS(computers,flag,idx);
            }
        }
    }
}
