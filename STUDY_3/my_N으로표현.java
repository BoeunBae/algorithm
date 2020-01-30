package STUDY_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class my_N으로표현 {
    public static int solution(int N, int number) {
    	HashMap<Integer, HashSet<Integer>> numbers = new HashMap<Integer, HashSet<Integer>>();
    	HashSet<Integer> set= new HashSet<Integer>(); 
    	set.add(1);
    	numbers.put(1, set);
    	if(N==number) return 1;
    	
    	for(int i = 2; i<9; i++) {
    		
    	}
    	
    	return -1;
    	
    }
    
    public static void main(String[] args) {
    	System.out.println(solution(5,12));
	}
}
