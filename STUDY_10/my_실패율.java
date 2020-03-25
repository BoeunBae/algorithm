package STUDY_10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Comparator;

public class my_실패율 {
	public int[] solution(int N, int[] stages) {
	    int[] answer = new int[N];
	    HashMap<Integer,Float> map = new HashMap<Integer,Float>();
	    for(int stage = 1; stage<=N; stage++){
	        float sum = 0, fail = 0;
	        for(int i = 0; i<stages.length; i++){
	            if(stages[i]>=stage)sum++;
	            if(stages[i]==stage)fail++;
	        }
	        if(sum!=0)map.put(stage,fail/sum);
	        else map.put(stage,0.0f);
	    }
	    LinkedList<Integer> list = new LinkedList<Integer>();
	    list.addAll(map.keySet());
	    list.sort(new Comparator<Object>(){
	        public int compare(Object o1, Object o2){
	            Float v1 = map.get(o1);
	            Float v2 = map.get(o2);
	            return ((Comparable)v2).compareTo(v1);
	        }
	    });
	    
	    for(int i = 0; i<answer.length; i++){
	        answer[i]=list.get(i);
	    }
	    return answer;
	}
}
