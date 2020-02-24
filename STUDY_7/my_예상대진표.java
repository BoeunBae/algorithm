package STUDY_7;

public class my_예상대진표 {
	public int solution(int n, int a, int b){
        int answer = 0;
        if(a>b){
            int tmp = a;
            a=b;
            b=tmp;
        }
        while(true){
            answer++;
            if(b-a==1 && a%2==1){
                break;
            }
            a=(a+1)/2;
            b=(b+1)/2;
            
        }
        return answer;
    }
}
