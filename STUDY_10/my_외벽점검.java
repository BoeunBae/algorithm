package STUDY_10;

import java.util.*;

public class my_외벽점검 {

    int answer = Integer.MAX_VALUE;
    int weak_len;
    LinkedList<Integer> extended_weak;
    
    public int solution(int n, int[] weak, int[] dist) {
        Arrays.sort(dist);
        weak_len = weak.length;
        boolean[] flag = new boolean[dist.length];
        extended_weak = new LinkedList<Integer>();
        for(int v : weak)extended_weak.add(v);//출발지 
        for(int v : weak)extended_weak.add(v+n);//출발지 기준 확장된 취약점
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        perm(0,0,list,dist,flag);
        
        if(answer==Integer.MAX_VALUE) answer = -1;
        return answer;
    }
    public void perm(int idx, int cnt, LinkedList<Integer> list, int[] dist,boolean[] flag){
        if(cnt==dist.length){
            possible(list);
            return;
        }
        for(int i = 0; i<dist.length; i++){
            if(!flag[i]){
                flag[i]=true;
                list.add(dist[i]);
                perm(i,cnt+1,list,dist,flag);
                list.removeLast();
                flag[i]=false;
            }
        }
    }
    public void possible(LinkedList<Integer> list){
        for(int i = 0; i<weak_len; i++){
            int idx = 0 ;
            int start = extended_weak.get(i);
            boolean mark = false;
            for(int j = i; j<i+weak_len; j++){
                if(extended_weak.get(j)-start > list.get(idx)){
                    start = extended_weak.get(j);
                    idx++;
                    if(idx==list.size()){
                        mark=true;
                        break;
                    }
                }
            }
            if(!mark) answer = Math.min(answer,idx+1);
        }
    }
	    

}
