package STUDY_7;
import java.util.HashSet;

public class my_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<String>();
        set.add(words[0]);
        for(int i = 1; i<words.length; i++){
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)
              || set.contains(words[i])){
                
                answer[0]=i%n+1;
                answer[1]=i/n+1;
                
                break; //break 안해주면 뒤에서 탈락하는 경우의 값을 return하게 되어 통과할 수 없게 된다. 가장 먼저 탈락하는 사람임을 기억하자...
            }
            else {
                set.add(words[i]);
            }
        }
        return answer;
    }
}
