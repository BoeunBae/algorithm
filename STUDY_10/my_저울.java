package STUDY_10;

import java.util.Arrays;

public class my_저울 {
    public int solution(int[] weight) {
        int answer = 1;
        Arrays.sort(weight);
        if(weight[0]!=1) return 1;
        for(int i = 1; i<weight.length; i++){
            if(answer+1>=weight[i]) answer+=weight[i]; //누적합+1값이 배열의 데이터보다 크거나 같아야 해당 값을 만들 수 있다.
            else break;
        }
        return answer+1;
    }
}
