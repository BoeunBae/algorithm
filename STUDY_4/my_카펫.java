package STUDY_4;

public class my_카펫 {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int v=0,h=0;
        for(int i = 1; i<=red; i++){
            v = i;
            h = red/i;
            if(v>=h&&(v+2)*(h+2)==red+brown) break;
        }
        answer[0]=v+2;
        answer[1]=h+2;
        return answer;
    }
}
