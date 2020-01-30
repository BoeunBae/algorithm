package STUDY_3;

public class other_N으로표현 {
    static int answer =-1;
    
    public static int solution(int N, int number) {
        
        dfs(N, number, 0,0);
        return answer;
    }
    static void dfs(int N, int number , int cnt, int prev) {
        //N의 카운트를 늘려가며 dfs 로 수행한다. 
        //그 값을 저장하고 그 값이 number와 동일한지 확인한다. 
        int temp_N = N;
        if (cnt > 8) {
            answer = -1;
            return;
        }
        
        if (number == prev) {
            if (answer == -1 || answer > cnt)
                answer = cnt;
            return;
        }
        
        for (int i = 0; i < 8-cnt; i++) {
            dfs(N, number, cnt+i+1, prev-temp_N);
            dfs(N, number, cnt+i+1, prev+temp_N);
            dfs(N, number, cnt+i+1, prev*temp_N);
            dfs(N, number, cnt+i+1, prev/temp_N);
            
            temp_N =  increaseNumber(temp_N, N);
        }
    }
    static int increaseNumber(int value, int N) {
        return value * 10 + N;
    }
    
    public static void main(String[] args) {
		System.out.println(solution(5,12));
	}
}
