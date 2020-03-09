package STUDY_9;

public class my_n진수게임 {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String strAnswer = "";
        for(int i = 0; i<t*m; i++){
            strAnswer+=toN(n,i);
        }
        
        for(int i = 1; i<=t; i++){
            answer += strAnswer.substring(0,m).charAt(p-1);
            strAnswer = strAnswer.substring(m);
        }
        return answer;
    }
    
    public String toN(int n, int num){
        String str = "";
        char[] code = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(num/n!=0){
            str = code[num%n]+str;
            num/=n;
        }
        str = code[num%n]+str;
        return str;
    }
}
