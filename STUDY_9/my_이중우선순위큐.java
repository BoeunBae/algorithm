package STUDY_9;

import java.util.PriorityQueue;

public class my_이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(String v : operations){
            if(v.split(" ")[0].equals("I"))pq.add(Integer.parseInt(v.split(" ")[1])); 
            else if(!pq.isEmpty()&&v.equals("D 1")) pq.remove(pq.stream().sorted().toArray()[pq.size()-1]); 
            //pq를 스트림으로 바꾸면 자동정렬되지 않으므로 추가로 sorted해주기
            else if(!pq.isEmpty()&&v.equals("D -1")) pq.poll();
        }
        if(pq.size()==0){
            answer[0]=0;
            answer[1]=0;
        }else{
            answer[0]=(int)pq.stream().sorted().toArray()[pq.size()-1];
            answer[1]=pq.poll();
        }
        return answer;
    }
}

