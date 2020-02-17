package STUDY_6;

//유클리드 호제법 활용
public class my_N개의최소공배수 {
	  public int solution(int[] arr) {
	      int lcm = arr[0];
	      for(int i = 1; i<arr.length ; i++){
	          lcm = lcm*arr[i] / getGcd(lcm,arr[i]);
	      }
	      return lcm;
	  }
	  public int getGcd(int a, int b){
	      int r;
	      while(b!=0){
	          r=a%b;
	          a=b;
	          b=r;
	      }
	      return a;
	  }
}
