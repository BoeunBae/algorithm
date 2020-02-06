package STUDY_4;

public class other_타일장식물 {
	  public long solution(int N) {
        long answer = 0;
        long[] arr = new long[N];
        for(int i = 0 ; i < N; i++){
            if(i==0 || i==1) arr[i]=1;
            else{
                arr[i]=arr[i-1]+arr[i-2];
            }
        }
        answer = 4*arr[N-1]+2*arr[N-2];
        return answer;
	}
}
