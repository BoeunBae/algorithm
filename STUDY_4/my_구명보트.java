package STUDY_4;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class my_구명보트 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int j = 0;
        for(int i = people.length-1; i>=j; i--){
           if(people[i]+people[j]<=limit) {
               answer++;
               j++;
           }
           else answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		System.out.println(solution(people,100));
	}
    
}
