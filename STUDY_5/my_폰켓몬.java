package STUDY_5;

import java.util.HashSet;
import java.util.Set;

public class my_폰켓몬 {
    public int solution(int[] nums) {
    	int n = nums.length/2;
    	Set<Integer> set = new HashSet<Integer>();
        for(int v : nums) set.add(v);
        return set.size() >= n ? n : set.size();
    }
}
