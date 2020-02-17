package STUDY_6;

//isPrime 대신 에라토스테네스의 체 사용 가능!

public class my_소수만들기 {
    int answer = 0;
    int[] arr = new int[2998]; //에라토스테네스의 체
    public int solution(int[] nums) {   
		  for(int i = 2; i<=2997; i++){
	          arr[i]=i;
	      }
	      
	      for(int i = 2; i<=2997; i++){
	          if(arr[i]==0) continue;
	          for(int j = i+i ; j<=2997 ; j+=i){
	              arr[j]=0;
	          }
	      }
         boolean[] flag = new boolean[nums.length];
         permutation(0,-1,0,nums,flag);
        
        return answer;
    }
    
    public void permutation(int cnt, int idx, int num, int[] nums, boolean[] flag){
        if(cnt==3){
            if(isPrime(num) || arr[num]!=0)answer++;
            return;
        } 
        for(int i = idx+1; i<nums.length; i++){
            if(!flag[i]){
                flag[i]=true;
                permutation(cnt+1,i,num+nums[i],nums,flag);
                flag[i]=false;
            }
        }        
    }
    public boolean isPrime(int n){
        if(n==0 || n==1) return false;
        
        for(int i = 2; i<n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
