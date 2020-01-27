package STUDY_2;

import java.util.Arrays;
import java.util.Comparator;

public class my_가장큰수 {
    public static String solution(int[] numbers) {
    	StringBuilder sb = new StringBuilder();
    	String[] strArray = new String[numbers.length];
    	for(int i=0;i<numbers.length;i++) strArray[i] = Integer.toString(numbers[i]);
    	
    	Arrays.sort(strArray,new Comparator<String>() {
    		@Override
    		public int compare(String o1, String o2) {
    			return (o2+o1).compareTo(o1+o2);
    		}//o1=10,o2=6이라고 가정했을 때, o2+o1=610, o1+o2=106이므로 return 값이 양수가 된다. 따라서 o1(10)이 o2(6)보다 크다고 판단하여
    		//배열에 6 10 의 순서로 정렬한다.
    	});
    	
    	for(String v : strArray) sb.append(v);
    	if(sb.charAt(0)=='0') return "0"; //0000 이라는 숫자일 경우 0으로 반환
    	else return sb.toString();
    }
}
