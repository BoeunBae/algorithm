package STUDY_7;

public class my_점프와_순간이동 {
    public int solution(int n) {
        int ans = 1;
        while(n>1){
            
            if(n%2!=0){
                n=n-1;
                ans++;
            }else{
                n=n/2;
            }
        }
        return ans;
    }
}
