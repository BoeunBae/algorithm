package STUDY_4;

//시간초과 효율성 0점
//메모이제이션 활용하기
public class my_타일장식물 {
	long[] m = new long[81];
	
    public long solution(int N) {
        long answer = 0;
        long max_length = getLength(N);
        long before_length = getLength(N-1);
        answer = 2*(max_length + before_length) + 2*max_length;
        return answer;
    }
    public long getLength(int N){
        if(N==1) return 1;
        if(N==2) return 1;
        if(m[N]!=0) return m[N];//이미 계산된 값일 경우 바로 반환
        return m[N]=getLength(N-1)+getLength(N-2);
    }
}
