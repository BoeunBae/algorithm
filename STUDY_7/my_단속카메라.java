package STUDY_7;

import java.util.Arrays;

public class my_단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,(o1,o2)->{
            return Integer.compare(o1[1],o2[1]);
        });
        int min = -300001;    
        for(int i = 0; i<routes.length; i++){
            if(min<routes[i][0]){
                answer++;
                min=routes[i][1];
            }
        }
        
        return answer;
    }
}
