package STUDY_4;

public class my_타켓넘버 {
    static int answer = 0;
    public static int solution(int[] numbers, int target) {
        DFS(numbers,target,0);
        return answer;
    }
    
    public static void DFS(int[] numbers, int target, int i){
        if(i==numbers.length){
            int sum = 0;
            for(int v : numbers){
                 sum+=v;
            }
            if(sum==target) answer++;
        }else{
            numbers[i]*=1;
            DFS(numbers,target,i+1);
            numbers[i]*=-1;
            DFS(numbers,target,i+1);
        }

    }
    public static void main(String[] args) {
    	int[] a = {1, 1, 1, 1, 1};
    	
		System.out.println(solution(a,3));
	}
}
