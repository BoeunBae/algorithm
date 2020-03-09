package STUDY_9;

import java.util.Arrays;

public class my_입국심사 {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long mid = 0, left = 0, right = (long)times[times.length-1]*(long)n; //long타입에 담아도 기존에 int인 변수는 연살할 때 int로 연산되므로 주의
        while(left<=right){
            mid = (left+right)/2;
            long cnt = 0;
            for(int i : times){
                cnt+=mid/i;
            }
            if(cnt<n)left=mid+1;
            else{
                answer=answer<mid?answer:mid;
                right=mid-1;
            }
        }
        return answer;
    }
}
