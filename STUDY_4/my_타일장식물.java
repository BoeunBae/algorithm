package STUDY_4;

//시간초과 효율성 0점
public class my_타일장식물 {
    public long solution(int N) {
        long answer = 0;
        long max_length = getLength(N);
        long before_length = getLength(N-1);
        answer = 2*(max_length + before_length) + 2*max_length;
        return answer;
    }
    public int getLength(int N){
        if(N==1) return 1;
        if(N==2) return 1;
        return getLength(N-1)+getLength(N-2);
    }
}
