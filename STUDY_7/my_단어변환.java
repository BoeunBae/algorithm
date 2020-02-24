package STUDY_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class my_단어변환 {	  
	//처음 짠 코드
	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		for(int i=0;i<words.length;i++) {
	    	if(target.equals(words[i])) {
	    		List<String> wordsList = new ArrayList<String>();
	        	for(String v : words) wordsList.add(v);
	        	List<Character> targetList = new ArrayList<Character>();
	        	for(int j = 0; j<target.length(); j++) targetList.add(target.charAt(j));
	    		answer = DFS(begin,target,targetList,wordsList);
	    	}
	    }
	    return answer;
	}
	static int cnt = 0;
	public static int DFS(String begin, String target,List<Character> targetList, List<String> wordsList) {
		if(begin.equals(target)) {
			return cnt;
		}
		else {    		
			char[] beginArr = begin.toCharArray();
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int i = 0; i<wordsList.size(); i++) {
				int changeChk = 0;
				int compareChk = 0;
				char[] compare = wordsList.get(i).toCharArray();
				for(int j = 0; j<begin.length(); j++) {
					if(beginArr[j]==compare[j])changeChk++;
					if(targetList.contains(compare[j])) compareChk++;
				}
				if(changeChk==begin.length()-1) {
					map.put(i, compareChk);
				}
			}
			
			int max = Collections.max(map.values());
			for(int v : map.keySet()) {
				if(max==map.get(v)) {
					begin=wordsList.get(v);
					cnt++;
					wordsList.remove(v);
					return DFS(begin,target,targetList,wordsList);
				}
			}
			
			return 0;
		}
	}
	
	//두 번째로 짠 코드(보다 효율적이다)
    int answer = 0;
    public int solution2(String begin, String target, String[] words) {
        boolean[] flag = new boolean[words.length];
        DFS(begin,target,words,flag,0);
        return answer;
    }
    
    public void DFS(String begin, String target, String[] words, boolean[] flag, int cnt){
        if(begin.equals(target)){
            answer = cnt;
            return;
        }
        
        for(int i = 0; i<words.length; i++){
            if(!flag[i]){
                int diff = 0;
                for(int j = 0; j<begin.length(); j++){
                    if(begin.charAt(j)!=words[i].charAt(j)) diff++;
                }
                if(diff==1){
                    flag[i]=true;
                    DFS(words[i],target,words,flag,cnt+1);
                    flag[i]=false;
                }
            }
        }
    }
}
