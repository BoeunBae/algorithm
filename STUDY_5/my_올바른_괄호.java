package STUDY_5;

public class my_올바른_괄호 {
    boolean solution(String s) {
        boolean answer = true;
        int cnt = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                if(i!=s.length()-1 && s.charAt(i+1)==')'){
                    i++;
                    continue;
                }
                else{
                    cnt++;
                }
            }else{
                if(cnt<=0) {
                    answer = false;
                    break;
                }else{
                    cnt--;
                }
            }
        }
        if(cnt>0) answer=false;
        return answer;
    }
}
