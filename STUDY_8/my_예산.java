package STUDY_8;

import java.util.Arrays;
public class my_예산 {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        Arrays.sort(budgets);
        
        long sum = 0;
        int mid = 0, left = M/budgets.length, right = budgets[budgets.length-1];
        
        for(int i : budgets) sum+=i;
        if(sum<=M) return answer = budgets[budgets.length-1];
        else{
            while(left<=right){
                sum = 0;
                mid = (left+right)/2;

                for(int i = 0; i<budgets.length; i++){
                    if(mid<=budgets[i]){
                        sum+=mid*(budgets.length-i);
                        break;
                    }else sum+=budgets[i];
                }
                if(sum<=M) {
                    left=mid+1;
                    answer=mid;
                }
                else right = mid-1;
            }
            
        }
        return answer;
    }
}
